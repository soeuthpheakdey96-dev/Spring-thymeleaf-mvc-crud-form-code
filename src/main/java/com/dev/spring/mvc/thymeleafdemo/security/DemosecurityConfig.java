package com.dev.spring.mvc.thymeleafdemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemosecurityConfig {
	
	@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		// define query to retrieve a user by usename
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id, pw, active from members where user_id=?");
		//define query to retrieve the authorities/roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id,role from roles where user_id=?");
		
	  return  jdbcUserDetailsManager;
	}

	 
	  
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http.authorizeHttpRequests(configurer ->
	        configurer
	            .requestMatchers("/employee/list-employee" , "/employee/search").hasAnyRole("EMPLOYEE","ADMIN","MANAGER","SUPER")
	            .requestMatchers("/employee/showFormForUpdate/**").hasRole("MANAGER")
	            .requestMatchers("/employee/deleteshowform/**").hasRole("ADMIN")
	            .requestMatchers("/pagesuper/**").hasRole("SUPER")
	            .anyRequest().authenticated()
	    )
//	    .formLogin(form -> form
//	        .loginPage("/employee/showMyLoginPage")
//	        .loginProcessingUrl("/authenticateTheUser")
//	        .permitAll()
	    
	    .formLogin(form -> form
	    	    .loginPage("/employee/showMyLoginPage")
	    	    .loginProcessingUrl("/authenticateTheUser")
	    	    .defaultSuccessUrl("/employee/list-employee", true)
	    	    .permitAll()
	    	
	    )
	    .logout(logout -> logout.permitAll())
	    .exceptionHandling(configurer ->
	        configurer.accessDeniedPage("/employee/access-denied")
	
	    );

	    return http.build();
	}
}

