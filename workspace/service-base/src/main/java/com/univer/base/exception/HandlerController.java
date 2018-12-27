package com.univer.base.exception;

import com.univer.base.constant.MsgConstant;
import com.univer.base.vo.ResultVo;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLException;

/**
 * @author guwei
 *
 * 异常处理
 */
@RestControllerAdvice
public class HandlerController {

	private static final Logger logger = LoggerFactory.getLogger(HandlerController.class);

    @Autowired
	private ResultVo<Object> resultVo;

	/**
	 * JWTToke过程的处理
	 */
	@ExceptionHandler(value = ExpiredJwtException.class)
	public Object expiredJwtException(ExpiredJwtException e) {
		resultVo.getInstance(MsgConstant.TOKEN_EXPIRED);
		return resultVo;
	}

	/**
	 * sql异常的处理
	 */
	@ExceptionHandler(value = SQLException.class)
	public Object sqlException(SQLException e) {
        resultVo.getInstance(MsgConstant.SQL_EXCEPTION);
        return resultVo;
	}

	/**
	 * 404的处理
	 */
	@ExceptionHandler(value = NoHandlerFoundException.class)
	public Object noHandlerFoundException(NoHandlerFoundException e) {
        resultVo.getInstance(HttpStatus.NOT_FOUND.toString());
        return resultVo;
	}

	/**
	 * 没有此方法的处理
	 */
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public Object httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        resultVo.getInstance(HttpStatus.METHOD_NOT_ALLOWED.toString());
        return resultVo;
	}

	/**
	 * 非法参数的处理
	 */
	@ExceptionHandler(value = IllegalArgumentException.class)
	public Object illegalArgumentException(IllegalArgumentException e) {
        resultVo.getInstance(MsgConstant.INVALID_DATA);
        return resultVo;
	}

	/**
	 * 数据格式转换异常的处理
	 */
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public Object httpMessageNotReadableException(HttpMessageNotReadableException e) {
        resultVo.getInstance(MsgConstant.INVALID_DATA);
        return resultVo;
	}

	/**
	 * 校验数据的处理
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResultVo methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getFieldError().getDefaultMessage();
        resultVo.getInstance(MsgConstant.INVALID_DATA, msg);
        return resultVo;
	}

	/**
	 * 参数类型转换失败的处理
	 */
	@ExceptionHandler(value = BindException.class)
	public Object bindException(BindException e) {
		resultVo.getInstance(MsgConstant.INVALID_DATA);
		return resultVo;
	}

}
