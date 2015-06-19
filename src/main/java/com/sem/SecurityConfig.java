package com.sem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * http://jaxenter.com/rest-api-spring-java-8-112289.html
 * @author AllenSooredoo
 *
 */
@EnableGlobalAuthentication
@Configuration
//@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/{

//	@Autowired
//	private  SemUserDetailsService userDetailsService;

//	@Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {       
//       auth.userDetailsService(userDetailsService);
//    }
	
	@Autowired
//	@Override
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("user").password("password").roles("USER").and()
		.withUser("MAXPAYNE").password("MAXPAYNE").roles("USER").and()
		.withUser("JACKDANIELS").password("JACKDANIELS").roles("USER").and()
		.withUser("admin").password("password").roles("USER", "ADMIN");
	}
}

