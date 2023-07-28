package com.example.BloxBankSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BloxBankSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloxBankSecurityApplication.class, args);
		PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		passwordEncoder.encode("s@1234");
		passwordEncoder.encode("s123456");
	}

}
