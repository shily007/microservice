package com.dy.auth.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 密码加密比对工具类
 * 
 * @author dy
 * 2020年12月17日
 */
public class PasswordUtil {

	private static final String ALGORITHM = "PBEWithMD5AndDES";// 加密算法
	private static final byte[] SALT = "54!@#$32".getBytes();// 密钥
	private static final int PASSWORD_LEN = 64;// 密码长度
	private static final int ITERATIONCOUNT = 1111;// 迭代次数为1000次

	/**
	 * 根据PBE密码生成一把密钥
	 *
	 * @param password 生成密钥时所使用的密码
	 * @return Key PBE算法密钥
	 */
	private static Key getPBEKey(String password) {
		// 实例化使用的算法
		SecretKeyFactory keyFactory;
		SecretKey secretKey = null;
		try {
			keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
			// 设置PBE密钥参数
			PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
			// 生成密钥
			secretKey = keyFactory.generateSecret(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return secretKey;
	}

	/**
	 * 加密明文字符串
	 *
	 * @param plaintext 待加密的明文字符串
	 * @param password  生成密钥时所使用的密码
	 * @param salt      盐值
	 * @return 加密后的密文字符串
	 * @throws Exception
	 */
	public static String encrypt(String plaintext, String password) {
		Key key = getPBEKey(password);
		byte[] encipheredData = null;
		PBEParameterSpec parameterSpec = new PBEParameterSpec(SALT, ITERATIONCOUNT);
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM);

			cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
			encipheredData = cipher.doFinal(plaintext.getBytes());
		} catch (Exception e) {
		}
		return bytesToHexString(encipheredData);
	}

	/**
	 * 加密密码 encryptPassword
	 * 
	 * @param plaintext
	 * @param password
	 * @return 返回64位加密字符串
	 * @author dy 2020年12月17日
	 */
	public static String encryptPassword(String plaintext, String password) {
		String encrypt = encrypt(plaintext, password);
		if (encrypt.length() >= PASSWORD_LEN) {
			return encrypt.substring(0, PASSWORD_LEN);
		}
		return encrypt + RandomStringUtils.randomAlphanumeric(PASSWORD_LEN - encrypt.length());
	}

	/**
	 * 比对输入的密码与加密后的密码是否匹配 comparePassword
	 * 
	 * @param plaintext
	 * @param password        未加密的密码
	 * @param encryptPassword 加密后的密码
	 * @return
	 * @author dy 2020年12月17日
	 */
	public static boolean comparePassword(String plaintext, String password, String encryptPassword) {
		String encrypt = encrypt(plaintext, password);
		if (encrypt.length() >= PASSWORD_LEN) {
			encrypt = encrypt.substring(0, PASSWORD_LEN);
			if (encrypt.equals(encryptPassword)) {
				return true;
			}
		}
		encryptPassword = encryptPassword.substring(0, encrypt.length());
		if (encrypt.equals(encryptPassword)) {
			return true;
		}
		return false;
	}

	/**
	 * 将字节数组转换为十六进制字符串
	 *
	 * @param src 字节数组
	 * @return
	 */
	private static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		String str = "username";
		System.out.println("username-->" + str.length());
		String password = "111111111111";
		try {
			String ciphertext = encryptPassword(str, password);
			System.out.println("密文:" + ciphertext);
			System.out.println("密文:" + ciphertext.length());
			boolean result = comparePassword(str, password, ciphertext);
			System.out.println("result:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}