package com.panonit.StinjanApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.panonit.StinjanApp.services.UserService;

@Configuration
@EnableWebSecurity
public class StinjanAppSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public BCryptPasswordEncoder getbCryptPasswordEncoder() {
		return bCryptPasswordEncoder;
	}

	public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/trip/*","/apartment/*","/lunch/*","/gallery*").permitAll()
			.anyRequest()
			.authenticated()
			.and()
		.formLogin()
			.defaultSuccessUrl("/trip/list", true)
			.and()
		.httpBasic();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails filipUser = User.builder()
				.username("admin")
				.password(bCryptPasswordEncoder.encode("admin"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(filipUser);
	}
}
