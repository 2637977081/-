package com.univer.account.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.univer.account.constant.MsgConstant;
import com.univer.account.service.UserService;
import com.univer.account.validation.EmailCaptcha;
import com.univer.account.validation.EmailCaptchaValid;
import com.univer.account.validation.Login;
import com.univer.account.validation.PasswordChange;
import com.univer.account.vo.UserVo;
import com.univer.base.bo.JwtToken;
import com.univer.base.bo.UserBo;
import com.univer.base.constant.ServiceConstant;
import com.univer.base.constant.StatusConstant;
import com.univer.base.constant.TypeConstant;
import com.univer.base.controller.BaseController;
import com.univer.base.grpc.message.MessageRequest;
import com.univer.base.grpc.message.MessageResponse;
import com.univer.base.util.CaptchaUtil;
import com.univer.base.util.JwtUtil;
import com.univer.base.util.VoUtils;
import com.univer.base.vo.ResultVo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author guwei
 */
@CrossOrigin
@RestController
@RequestMapping("/account/")
@Scope("prototype")
public class AccountController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private MessageSource messageSource;

    @Value("${captcha.timeout}")
    private long captchaTimeout;

    @Value("${bcrypt.salt}")
    private int bcryptSalt;

    @Autowired
    protected JwtUtil<UserBo> jwtUtil;

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private UserVo userVo;

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @PostMapping("login")
    public ResultVo login(@RequestBody @Validated({Login.class}) UserVo temp) throws Exception {
        VoUtils.copyProperties(temp, userVo, "commonName", "password", "random", "captcha");
        UserVo persist = userService.findUser(userVo.getCommonName());
        if (persist != null) {
            if (persist.getCaptchaStatus()) {
                if (!StringUtils.isNotEmpty(userVo.getCaptcha())) {
                    return resultVo.getInstance(MsgConstant.CAPTCHA_NOT_EXISTED);
                }
                if (StringUtils.isNotEmpty(userVo.getRandom()) && StringUtils.isNotEmpty(userVo.getCaptcha())) {
                    String captcha = CaptchaUtil.getCaptcha(template, userVo.getRandom());
                    if (userVo.getCaptcha().equalsIgnoreCase(captcha)) {
                        loginUser(persist);
                    } else {
                        resultVo.getInstance(MsgConstant.CAPTCHA_ERROR);
                    }
                } else {
                    resultVo.getInstance(MsgConstant.CAPTCHA_ERROR);
                }
            } else {
                loginUser(persist);
            }
        } else {
            resultVo.getInstance(MsgConstant.LOGIN_ERROR);
        }
        return resultVo;
    }

    /**
     * 验证用户并记录用户状态
     */
    private void loginUser(UserVo persist) throws JsonProcessingException {
        if (BCrypt.checkpw(userVo.getPassword(), persist.getPassword())) {
            if (StatusConstant.ENABLED.equals(persist.getStatus())) {
                String code = persist.getCode();
                String jwtToken = jwtUtil.createJWT(code, objectMapper.writeValueAsString(new UserBo(persist.getUserId(), persist.getCode(), persist.getUsername(), persist.getName(), persist.getPhone(), persist.getEmail())));
                persist.setJwtToken(new JwtToken(code, TypeConstant.BEARER_TOKEN, jwtToken, jwtUtil.getTtlMillis()));
                // 缓存用户信息
                template.opsForValue().set(code, objectMapper.writeValueAsString(persist));
                // 不需要验证码
                persist.setCaptchaStatus(false);
                userService.updateCaptchaStatus(persist);
                //persist.set
                resultVo.getInstance(HttpStatus.OK.toString(), persist);
            } else {
                resultVo.getInstance(MsgConstant.LOGIN_USER_ERROR);
            }
        } else {
            // 需要验证码
            persist.setCaptchaStatus(true);
            userService.updateCaptchaStatus(persist);
            resultVo.getInstance(MsgConstant.LOGIN_ERROR);
        }
    }

    /**
     * 用户登出
     */
    @PostMapping("logout")
    public ResultVo logout(@RequestHeader(name = "Univer-Code", required = true) String code) {
        Boolean flag = template.delete(code);
        if (flag) {
            resultVo.getInstance(HttpStatus.OK.toString());
        } else {
            resultVo.getInstance(MsgConstant.LOGOUT_ERROR);
        }
        return resultVo;
    }

    /**
     * 获取验证码
     */
    @GetMapping("captcha")
    public ResponseEntity<byte[]> captcha(@RequestParam("random") String random, HttpEntity<byte[]> requestEntity) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setCacheControl("no-cache,no-store,must-revalidate");
        responseHeaders.setPragma("no-cache");
        responseHeaders.setExpires(0);
        responseHeaders.setContentType(MediaType.IMAGE_JPEG);
        String captcha = RandomStringUtils.random(4, CaptchaUtil.CHARS);
        template.opsForValue().set(random, captcha.toLowerCase(), captchaTimeout, TimeUnit.MILLISECONDS);
        byte[] imageByte = CaptchaUtil.createImage(captcha);
        return new ResponseEntity<byte[]>(imageByte, responseHeaders, HttpStatus.OK);
    }

    /**
     * 判断用户是否存在
     */
    @GetMapping("exist")
    public ResultVo exist(@RequestParam("userId") Long userId, @RequestParam("commonName") String commonName) {
        UserVo persist = userService.findUser(userId, commonName);
        if (persist != null) {
            resultVo.getInstance(MsgConstant.USER_EXISTED);
        } else {
            resultVo.getInstance(MsgConstant.USER_NOT_EXISTED);
        }
        return resultVo;
    }

    /**
     * 验证码发送到邮箱
     */
    @RequestMapping("email/captcha")
    public ResultVo emailCaptcha(@RequestBody @Validated({EmailCaptcha.class}) UserVo temp) throws MessagingException, IOException {
        System.out.println(temp);
        UserVo persist = userService.findUser(temp.getEmail());
        if (persist == null) {
            return resultVo.getInstance(MsgConstant.INVALID_USER);
        }
        String captcha = RandomStringUtils.random(6, CaptchaUtil.NUMBERS);
        template.opsForValue().set(temp.getRandom(), captcha.toLowerCase(), captchaTimeout, TimeUnit.MILLISECONDS);
        String subject = messageSource.getMessage("forgot.password.subject", null, LocaleContextHolder.getLocale());
        String content = messageSource.getMessage("forgot.password.content", new Object[]{captcha, temp.getEmail(), DateFormatUtils.format(new Date(), "yyyy-MM-dd")}, LocaleContextHolder.getLocale());
//        final ManagedChannel channel = ManagedChannelBuilder.forAddress(ServiceConstant.SERVICE_MESSAGE, ServiceConstant.SERVICE_MESSAGE_GRPC_PORT).usePlaintext().build();
        try {
//            ManagedChannel channel = SingletonMessageChannel.getManagedChannel();
//            MessageServiceGrpc.MessageServiceBlockingStub stub = MessageServiceGrpc.newBlockingStub(channel);
//
//            HashMap<Object, Object> jsonDataMap = new HashMap<>(5);
//            jsonDataMap.put("subject", subject);
//            jsonDataMap.put("content", content);
//            jsonDataMap.put("recipientEmail", temp.getEmail());
//
//            //把包装的数据发送给grpc服务端
//            String jsonData = objectMapper.writeValueAsString(jsonDataMap);
//            MessageRequest request = MessageRequest.newBuilder().setJsonData(jsonData).build();
//            //grpc服务端响应
//            MessageResponse response = stub.captcha(request);
//            String responseJsonData = response.getJsonData();
//            Boolean resultBool = objectMapper.readValue(responseJsonData, Boolean.class);
//            if (resultBool) {
//                resultVo.getInstance(HttpStatus.OK.toString());
//            } else {
//                resultVo.getInstance(MsgConstant.SEND_EMAIL_ERROR);
//            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 验证邮箱验证码
     */
    @PostMapping("email/captcha/valid")
    public ResultVo emailCaptchaValid(@RequestBody @Validated({EmailCaptchaValid.class}) UserVo temp) throws JsonProcessingException {
        String captcha = CaptchaUtil.getCaptcha(template, temp.getRandom());
        if (captcha != null && captcha.equals(temp.getCaptcha())) {
            UserVo persist = userService.findUser(temp.getEmail());
            if (persist == null) {
                return resultVo.getInstance(MsgConstant.INVALID_USER);
            }
            String code = persist.getCode();
            String jwtToken = jwtUtil.createJWT(code, objectMapper.writeValueAsString(new UserBo(persist.getUserId(), persist.getCode(), persist.getUsername(), persist.getName(), persist.getPhone(), persist.getEmail())));
            persist.setJwtToken(new JwtToken(code, TypeConstant.BEARER_TOKEN, jwtToken, jwtUtil.getTtlMillis()));
            // 缓存用户信息
            template.opsForValue().set(code, objectMapper.writeValueAsString(persist));
            resultVo.getInstance(HttpStatus.OK.toString(), persist);
        } else {
            resultVo.getInstance(MsgConstant.CAPTCHA_ERROR);
        }
        return resultVo;
    }

    /**
     * 更换密码
     */
    @PostMapping("email/captcha/change/password")
    public ResultVo emailCaptchaChangePassword(@RequestBody @Validated({PasswordChange.class}) UserVo temp) throws JsonProcessingException {

        if (temp.getRandom() != null && temp.getCaptcha() != null) {
            String captcha = CaptchaUtil.getCaptcha(template, temp.getRandom());
            if (captcha != null && captcha.equals(temp.getCaptcha())) {
                if (temp.getNewPassword().equals(temp.getConfirmPassword())) {
                    UserVo persist = userService.findUser(temp.getEmail());
                    if (persist == null) {
                        return resultVo.getInstance(MsgConstant.INVALID_USER);
                    }
                    persist.setPassword(BCrypt.hashpw(temp.getNewPassword(), BCrypt.gensalt(bcryptSalt)));
                    // 设置非重置状态
                    persist.setResetStatus(false);
                    Boolean flag = userService.updatePassword(persist);
                    if (flag) {
                        resultVo.getInstance(HttpStatus.OK.toString());
                    } else {
                        resultVo.getInstance(MsgConstant.UPDATE_ERROR);
                    }
                } else {
                    resultVo.getInstance(MsgConstant.USER_PASSWORD_NOT_EQUAL);
                }
            } else {
                resultVo.getInstance(MsgConstant.CAPTCHA_ERROR);
            }
        } else {
            resultVo.getInstance(MsgConstant.CAPTCHA_ERROR);
        }
        return resultVo;
    }

    /**
     * 验证码发送到手机
     */
    @PostMapping("phone/captcha")
    public ResultVo phoneCaptcha(UserVo temp) throws Exception {
        String captcha = RandomStringUtils.random(6, CaptchaUtil.NUMBERS);
        template.opsForValue().set(temp.getRandom(), captcha.toLowerCase(), captchaTimeout, TimeUnit.MILLISECONDS);
        String title = messageSource.getMessage("forgot.password.title", null, LocaleContextHolder.getLocale());
        String text = messageSource.getMessage("forgot.password.text", null, LocaleContextHolder.getLocale()) + captcha;
        // todo
//        Boolean flag = smsService.sendSms(temp.getPhone(),"");
//        if(flag) {
//            resultVo.getInstance(HttpStatus.OK.toString());
//        }
        return resultVo;
    }
}
