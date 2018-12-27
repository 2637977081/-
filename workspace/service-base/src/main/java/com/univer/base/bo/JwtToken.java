package com.univer.base.bo;

/**
 * @author guwei
 *
 * JWT Token
 */
public class JwtToken {

	private String code;
	private String tokenType;
	private String accessToken;
	private long expiredTime;

	public JwtToken() {
		super();
	}

	public JwtToken(String code, String tokenType, String accessToken, long expiredTime) {
		super();
		this.code = code;
		this.tokenType = tokenType;
		this.accessToken = accessToken;
		this.expiredTime = expiredTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(long expiredTime) {
		this.expiredTime = expiredTime;
	}

}
