package com.johnbryce.talent.hackathon.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.tomcat.util.codec.binary.Base64;

public class SecurityUtils {

	private static final String HASHING_TECHNIQUE = "SHA-256";

	public static byte[] generateSalt() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		return bytes;
	}

	public static String bytetoString(byte[] input) {
		return Base64.encodeBase64String(input);
	}

	public static byte[] getHashWithSalt(String input, byte[] salt) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(HASHING_TECHNIQUE);
		digest.reset();
		digest.update(salt);
		byte[] hashedBytes = digest.digest(stringToByte(input));
		return hashedBytes;
	}

	public static byte[] stringToByte(String input) {
		if (Base64.isBase64(input)) {
			return Base64.decodeBase64(input);

		} else {
			return Base64.encodeBase64(input.getBytes());
		}
	}
}
