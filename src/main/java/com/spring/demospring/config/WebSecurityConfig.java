package com.spring.demospring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration


public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		// security.httpBasic().disable();
		// security.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated();
		security
		.headers()
		.frameOptions()
		.sameOrigin()
		.and()
		.csrf()
		.disable()
		.exceptionHandling()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.cors()
		.and()
		.authorizeRequests()
		.antMatchers(
				"/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js")
		.permitAll()

		.antMatchers("/h2/**")
		.permitAll()
		.anyRequest()
		.permitAll();
	}

}
