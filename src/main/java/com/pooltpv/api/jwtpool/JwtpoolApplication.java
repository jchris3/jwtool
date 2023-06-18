package com.pooltpv.api.jwtpool;

import com.pooltpv.api.jwtpool.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.jdbc.Sql;

@Sql({"/user.sql"})
@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class JwtpoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtpoolApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
