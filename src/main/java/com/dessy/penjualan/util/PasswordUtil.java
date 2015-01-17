package com.dessy.penjualan.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
	
	public static void main(String[] args) {
		System.out.println("Password " + getMD5Digest("dessy"));
	}

	public static String getMD5Digest(String string){
		
		String generatedPassword = null;
		
		try {
			//buat instance MessageDigest Untuk MD5
			MessageDigest md = MessageDigest.getInstance("MD5");


			md.update(string.getBytes());
			byte[] bytes = md.digest();

			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bytes.length; i++){
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
			}

			generatedPassword = sb.toString();


		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}


		return generatedPassword;
	}

}


