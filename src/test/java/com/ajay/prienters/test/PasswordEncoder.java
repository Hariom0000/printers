package com.ajay.prienters.test;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public class PasswordEncoder {
	public static void main(String []args){
		MessageDigestPasswordEncoder ms = new MessageDigestPasswordEncoder(
				"MD5");
		System.out.println(ms.encodePassword("123456", null));
	}

}
