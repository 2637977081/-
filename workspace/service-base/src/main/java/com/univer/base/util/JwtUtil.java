package com.univer.base.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.base.constant.TypeConstant;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author guwei
 */
@ConfigurationProperties(prefix = "jjwt")
@Component
public class JwtUtil<T> {

	@Autowired
	private ObjectMapper objectMapper;
	
	private String secret;
	private long ttlMillis;

	/**
	 * 由字符串生成加密key
	 */
	public SecretKey generalKey() {
		SecretKey key = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
		return key;
	}

	/**
	 * 创建jwt
	 */
	public String createJWT(String id, String subject) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Calendar calendar = Calendar.getInstance();
		Date issuedDate = calendar.getTime();
		calendar.setTimeInMillis(issuedDate.getTime() + ttlMillis);
		Date expirationDate = calendar.getTime();
		SecretKey key = generalKey();
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(issuedDate).setSubject(subject).signWith(signatureAlgorithm,key).setExpiration(expirationDate);
		return builder.compact();
	}

	/**
	 * 解密jwt
	 */
	public String parseJWT(String jwt) {
		SecretKey key = generalKey();
		return Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody().getSubject();
	}

	/**
	 * 生成subject信息
	 */
	public String generateSubject(T t) {
		String jsonString = null;
		try {
			jsonString = objectMapper.writeValueAsString(t);
		} catch (Exception e) {

		}
		return jsonString;
	}

    /**
     * 把授权码解析成用户信息
     */
    public T getT(String authorization, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException, InstantiationException, IllegalAccessException {
        T t = clazz.newInstance();
        if (!StringUtils.isEmpty(authorization)) {
            String subject = parseJWT(authorization);
            t = objectMapper.readValue(subject, clazz);
        }
        return t;
    }

	/**
	 * 生成秘钥
	 */
	public String generateSecretKey() {
		String key = null;
		try {
			KeyGenerator kg = KeyGenerator.getInstance(SignatureAlgorithm.HS256.getJcaName());
			kg.init(256);
			SecretKey sk = kg.generateKey();
			byte[] b = sk.getEncoded();
			key = byteToHexString(b);
		} catch (Exception e) {

		}
		return key;

	}

	/**
	 * 字节转字符串
	 */
	public String byteToHexString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String strHex = Integer.toHexString(bytes[i]);
			if (strHex.length() > 3) {
				sb.append(strHex.substring(6));
			} else {
				if (strHex.length() < 2) {
					sb.append("0" + strHex);
				} else {
					sb.append(strHex);
				}
			}
		}
		return sb.toString();
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public long getTtlMillis() {
		return ttlMillis;
	}

	public void setTtlMillis(long ttlMillis) {
		this.ttlMillis = ttlMillis;
	}

}