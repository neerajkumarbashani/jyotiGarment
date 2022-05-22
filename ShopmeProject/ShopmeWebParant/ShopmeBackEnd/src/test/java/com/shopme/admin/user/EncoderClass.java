package com.shopme.admin.user;

import org.junit.jupiter.api.Test;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncoderClass extends WebSecurityConfigurerAdapter {

	PasswordEncoder encoder=new BCryptPasswordEncoder();
	
	@Test
	public void testEncoderPassword() {
		String a=encoder.encode("12345");
		System.out.println("sedfe "+a);
		
	}
}
