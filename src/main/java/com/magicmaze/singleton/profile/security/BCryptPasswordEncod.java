package com.magicmaze.singleton.profile.security;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncod implements PasswordEncoder {

	int strength = 10; // work factor of bcrypt
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
	
	@Override
	public String encode(CharSequence rawPassword) {
		String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
		return encodedPassword;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
	}

}
