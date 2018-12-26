package com.univer.account.controller;

import com.github.pagehelper.PageInfo;
import com.univer.account.constant.MsgConstant;
import com.univer.account.po.User;
import com.univer.account.service.UserService;
import com.univer.account.validation.PasswordUpdate;
import com.univer.account.validation.UserAdd;
import com.univer.account.validation.UserUpdate;
import com.univer.account.vo.UserVo;
import com.univer.base.controller.AuthorizationController;
import com.univer.base.enums.StatusEnum;
import com.univer.base.util.CaptchaUtil;
import com.univer.base.util.UUIDUtil;
import com.univer.base.util.VoUtils;
import com.univer.base.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author guwei
 */
@RestController
@RequestMapping("/user/")
@Scope("prototype")
public class UserController extends AuthorizationController<Object> {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${bcrypt.salt}")
    private int bcryptSalt;

	@Autowired
	private StringRedisTemplate template;

    @Autowired
    private UserVo userVo;

	@Autowired
	private UserService userService;

	/** 
     * 列表查询
     */
	@GetMapping("list")
	public ResultVo list(UserVo temp) throws Exception {
        VoUtils.copyProperties(temp, userVo, "username", "name", "phone", "email", "type", "orgId", "createrId", "status", "roleName", "page", "rows");
		List<UserVo> list = userService.findByPage(userVo);
		PageInfo<UserVo> pageInfo = new PageInfo<UserVo>(list);
		resultVo.getInstance(HttpStatus.OK.toString(), pageInfo);
		return resultVo;
	}
	
	/** 
     * 查询详情
     */
	@GetMapping("detail/{userId}")
	public ResultVo detail(@PathVariable Long userId) {
		UserVo userVo = userService.findUserById(userId);
		if(userVo != null) {
			resultVo.getInstance(HttpStatus.OK.toString(), userVo);
        } else {
			resultVo.getInstance(MsgConstant.NO_DATA, userVo);
        }
		return resultVo;
	}

	/** 
     * 创建
     */
	@PostMapping("add")
	public ResultVo add(@RequestBody @Validated( {UserAdd.class }) UserVo temp ) throws Exception {
        VoUtils.copyProperties(temp, userVo,"username", "name", "email", "phone", "password","gender", "avatar", "description", "orgId", "roleVoList", "status");
	    if(userService.isExistedUser(userVo)) {
            resultVo.getInstance(MsgConstant.USER_EXISTED, userVo);
        } else {
			if (userVo.getStatus() != null && StatusEnum.getStatus(userVo.getStatus())== null) {
				resultVo.getInstance(MsgConstant.INVALID_DATA);
			}else {
				userVo.setCode(UUIDUtil.getUUID());
				userVo.setCreaterId(loginUser.getUserId());
				userVo.setPassword(BCrypt.hashpw(userVo.getPassword(), BCrypt.gensalt(bcryptSalt)));
				userVo = userService.saveUser(userVo);
				if (userVo != null) {
					resultVo.getInstance(HttpStatus.OK.toString(), userVo);
				} else {
					resultVo.getInstance(MsgConstant.CREATE_ERROR, userVo);
				}
			}
        }
		return resultVo;
	}

	public ResultVo uplaodImage(){
		return resultVo;
	}

	/** 
     * 更新
     */
	@PostMapping("update")
	public ResultVo update(@RequestBody @Validated( {UserUpdate.class }) UserVo temp) throws Exception {
        VoUtils.copyProperties(temp, userVo, "userId", "name", "email", "phone", "password", "avatar", "description", "orgId","status", "roleVoList" );
        if(StringUtils.isNotEmpty(userVo.getPassword())) {
			userVo.setPassword(BCrypt.hashpw(userVo.getPassword(), BCrypt.gensalt(bcryptSalt)));
		}
        userVo = userService.updateUser(userVo);
        if (userVo != null) {
            resultVo.getInstance(HttpStatus.OK.toString(), userVo);
        } else {
            resultVo.getInstance(MsgConstant.UPDATE_ERROR, userVo);
        }
		return resultVo;
	}

    /**
     * 修改密码
     */
    @PostMapping("update/password")
    public ResultVo updatePassword(@RequestBody @Validated( { PasswordUpdate.class }) UserVo temp) throws Exception {
		VoUtils.copyProperties(temp, userVo, "password", "newPassword", "confirmPassword", "random", "captcha");
        userVo.setUserId(loginUser.getUserId());
		if(userVo.getRandom() != null && userVo.getCaptcha() != null) {
			String captcha = CaptchaUtil.getCaptcha(template, userVo.getRandom());
			if (userVo.getCaptcha().equalsIgnoreCase(captcha)) {
				if(BCrypt.checkpw(userVo.getPassword(), loginUser.getPassword()) && userVo.getNewPassword().equals(userVo.getConfirmPassword())) {
					userVo.setUserId(loginUser.getUserId());
					userVo.setPassword(BCrypt.hashpw(userVo.getNewPassword(), BCrypt.gensalt(bcryptSalt)));
					// 设置非重置状态
					userVo.setResetStatus(false);
					Boolean flag = userService.updatePassword(userVo);
					if (flag) {
						resultVo.getInstance(HttpStatus.OK.toString());
					} else {
						resultVo.getInstance(MsgConstant.UPDATE_ERROR);
					}
				}else {
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
     * 删除
     */
	@DeleteMapping("delete/{userId}")
	public ResultVo delete(@PathVariable Long userId) throws Exception {
		int num = userService.deleteUser(userId);
		if (num == 1) {
            resultVo.getInstance(HttpStatus.OK.toString());
		}
		return resultVo;
	}

	/** 
     * 批量删除
     */
	/**@DeleteMapping("deleteList")*/
	public ResultVo delete(@RequestParam(defaultValue = "") String ids) throws Exception {
		int num = userService.deleteByIds(ids);
		if (num > 0) {
            resultVo.getInstance(HttpStatus.OK.toString());
		}
		return resultVo;
	}

	/**
	 * @description: 批量查询用户信息
	 * @author:lvgang
	 * @date: 2018/10/11 14:24
	 **/
	@GetMapping("list/ids")
	public ResultVo listByIds(@RequestParam("ids") String ids)throws Exception{
		List<User> list = userService.findByIds(ids);
		if(list.size()>0){
			resultVo.getInstance(HttpStatus.OK.toString(),list);
		}else{
			resultVo.getInstance(MsgConstant.NO_DATA,list);
		}
		return resultVo;
	}
}