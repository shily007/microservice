package com.dy.authorization.rsa;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dy.authorization.properties.SecurityConstants;

/**
 * 
 * @author dy
 *
 */
public class RSAUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(Object.class);

	/**
	 * 加密算法RSA
	 */
	public static final String KEY_ALGORITHM = "RSA";

	/**
	 * 签名算法
	 */
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	/**
	 * 获取公钥的key
	 */
	private static final String PUBLIC_KEY = "RSAPublicKey";

	/**
	 * 获取私钥的key
	 */
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	/**
	 * 随机生成密钥对
	 */
	public static Map<String, String> genKeyPair() {

		Map<String, String> keyMap = new HashMap<String, String>(); // 用于封装随机产生的公钥与私钥

		try {
			// KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);

			// 初始化密钥对生成器，密钥大小为96-1024位
			keyPairGen.initialize(1024, new SecureRandom());

			// 生成一个密钥对，保存在keyPair中
			KeyPair keyPair = keyPairGen.generateKeyPair();
			RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate(); // 得到私钥
			RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic(); // 得到公钥

			// 得到公钥字符串
			String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
			// 得到私钥字符串
			String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));

			// 将公钥和私钥保存到Map
			keyMap.put(PUBLIC_KEY, publicKeyString); // 0表示公钥
			keyMap.put(PRIVATE_KEY, privateKeyString); // 1表示私钥
		} catch (Exception e) {
			logger.info("生成公钥私钥异常：" + e.getMessage());
			return null;
		}

		return keyMap;
	}

	/**
	 * RSA公钥加密
	 * 
	 * @param str       需要加密的字符串
	 * @param publicKey 公钥
	 * @return 公钥加密后的内容
	 */
	public static String encrypt(String str, String publicKey) {
		String outStr = null;
		try {
			// base64编码的公钥
			byte[] decoded = Base64.decodeBase64(publicKey);
			RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(KEY_ALGORITHM)
					.generatePublic(new X509EncodedKeySpec(decoded));
			// RSA加密
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
		} catch (Exception e) {
			logger.info("使用公钥加密【" + str + "】异常：" + e.getMessage());
		}
		return outStr;
	}

	/**
	 * RSA私钥解密
	 * 
	 * @param str        加密字符串
	 * @param privateKey 私钥
	 * @return 私钥解密后的内容
	 */
	public static String decrypt(String str, String privateKey) {
		String outStr = null;
		try {
			// 64位解码加密后的字符串
			byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
			// base64编码的私钥
			byte[] decoded = Base64.decodeBase64(privateKey);
			RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(KEY_ALGORITHM)
					.generatePrivate(new PKCS8EncodedKeySpec(decoded));
			// RSA解密
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, priKey);
			outStr = new String(cipher.doFinal(inputByte));
		} catch (Exception e) {
			logger.info("使用私钥解密异常：" + e.getMessage());
		}
		return outStr;
	}

	public static void main(String[] args) throws Exception {
//		String s = "haha123!@#$%^&*()_+-=上手的“'\'/?><";
//		Map<String, String> map = RSAUtil.genKeyPair();
//		System.out.println("公钥：" + map.get(SecurityConstants.PUBLIC_KEY));
//		System.out.println("私钥：" + map.get(SecurityConstants.PRIVATE_KEY));
		String s2 = RSAUtil.encrypt("123456", SecurityConstants.PUBLIC_KEY);
//		String s2 = "fdfNLmBUarAL2YhA5AUiKnkTxTx71gH6HiD82VIPWPJ7ah/W2JwJxA5vI1KRza8eSv9eDIREJVxu8y4n9thr1GWz80ANi3RrAseCCU9WckdyZUJQpsUSoqbs40o+jJSzf9qzWlHhIGzrlfI0nZvY3Vj7AKEzvn5laKcFPL6B+W4=";
		System.out.println("加密后：" + s2);
		System.out.println("解密后：" + RSAUtil.decrypt(s2, SecurityConstants.PRIVATE_KEY));
		PasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("123456"));
	}

}
