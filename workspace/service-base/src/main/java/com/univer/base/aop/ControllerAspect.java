package com.univer.base.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.base.bo.SysLogBo;
import com.univer.base.bo.UserBo;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author hongjiao
 */
@Aspect
@Component
@Scope("prototype")
public class ControllerAspect {

    @Autowired
    private SysLogBo sysLogBo;
    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StringRedisTemplate template;

    /**
     * 开始时间
     */
    private long start;
    /**
     * 结束时间
     */
    private long end;

    @Pointcut("execution(public * com.univer.*.controller..*.*(..)) && !execution(public * com.univer.storage.controller..*.saveSysLog(..))")
    public void controllerLog(){}

    /**
     * 记录请求信息
     */
    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        start = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        // TODO logTitle、logType待定
        sysLogBo.setLogTitle("");
        sysLogBo.setLogType("");
        sysLogBo.setBrowserName(userAgent.getBrowser().toString());
        sysLogBo.setCreateTime(new Date());
        sysLogBo.setDeviceName(userAgent.getOperatingSystem().getName());
        // 用户
        //sysLogBo.setOperator(request.getRemoteUser());
        sysLogBo.setOperator(getUser(request));
        sysLogBo.setRequestUri(request.getRequestURI());
        sysLogBo.setRemoteAddr(getIp(request));
        sysLogBo.setServerAddr(request.getRequestURL().toString().replace(request.getRequestURI(),""));
        sysLogBo.setRequestMethod(request.getMethod());
        try {
            sysLogBo.setRequestParams(objectMapper.writeValueAsString(joinPoint.getArgs()));
        } catch (JsonProcessingException e) {
            logger.warn("Request params is not json");
        } finally {
            sysLogBo.setRequestParams("No Json");
        }
        sysLogBo.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    /**
     * 日志输出
     */
    @AfterReturning(returning = "ret", pointcut = "controllerLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        end = System.currentTimeMillis();
        sysLogBo.setExecuteTime(end - start);
        sysLogBo.setException(false);
        sysLogBo.setResponseParams(objectMapper.writeValueAsString(ret));
        saveSysLog(sysLogBo);
        logger.info(objectMapper.writeValueAsString(sysLogBo));
    }

    /**
     * 异常输出
     */
    @AfterThrowing(throwing = "ex",pointcut = "controllerLog()")
    public void doAfterThrowing(Throwable ex) throws Throwable{
        end = System.currentTimeMillis();
        sysLogBo.setExecuteTime(end - start);
        sysLogBo.setException(true);
        sysLogBo.setExceptionInfo(ex.getMessage());
        saveSysLog(sysLogBo);
        logger.error(objectMapper.writeValueAsString(sysLogBo));
    }

    /**
     * 获取IP地址
     */
    public static String getIp(HttpServletRequest request) {
       String ip = request.getHeader("X-Forwarded-For");
       String ipUnKnown = "unKnown";
        if(StringUtils.isNotEmpty(ip) && !ipUnKnown.equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !ipUnKnown.equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
   }

    /**
     * 存储日志
     * @param sysLogBo
     * @throws Exception
     */
   private void saveSysLog(SysLogBo sysLogBo) throws Exception{
       try{
//           //final ManagedChannel channel = ManagedChannelBuilder.forAddress(ServiceConstant.SERVICE_STORAGE, ServiceConstant.SERVICE_STORAGE_GRPC_PORT).usePlaintext().build();
//           ManagedChannel channel = SingletonStorageChannel.getManagedChannel();
//           StorageServiceGrpc.StorageServiceBlockingStub stub = StorageServiceGrpc.newBlockingStub(channel);
//           String value = objectMapper.writeValueAsString(sysLogBo);
//           StorageRequest request = StorageRequest.newBuilder().setJsonData(value).build();
//           StorageResponse response = stub.logStorage(request);
//           String result = response.getJsonData();
//           logger.info("sys log save info"+result);
       }catch (Exception e){
           e.printStackTrace();
           logger.error(e.getMessage());
       }

   }

    /**
     * 获取用户id
     * @param request
     * @return
     * @throws Exception
     */
   private String getUser( HttpServletRequest request){
       try {
           String code = request.getHeader("Univer-Code");
           if(!code.isEmpty()){
               String uuidValue = template.opsForValue().get(code);
               if(!uuidValue.isEmpty()){
                   UserBo userBo = objectMapper.readValue(uuidValue,UserBo.class);
                   return userBo.getUserId().toString();
               }
           }
       }catch (Exception e){
           logger.error(e.getMessage());
       }
       return "Unknown";
   }
}
