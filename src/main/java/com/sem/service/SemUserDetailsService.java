package com.sem.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * http://docs.spring.io/spring-security/site/docs/3.1.x/reference/technical-
 * overview.html
 * 
 * http://jaxenter.com/rest-api-spring-java-8-112289.html
 * 
 * @author AllenSooredoo
 * 
 */
//@Service
public class SemUserDetailsService implements UserDetailsService {

//	@Autowired
//	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

//		customerRepository.count().
//		User user = loadUserByUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("Username " + username
//					+ " not found");
//		}
		return new User(username, "password", getGrantedAuthorities(username));
	}

	private Collection<? extends GrantedAuthority> getGrantedAuthorities(
			String username) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (username.equals("John")) {
			 authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			 authorities.add(new SimpleGrantedAuthority("ROLE_BASIC"));
		} else {
			authorities.add(new SimpleGrantedAuthority("ROLE_BASIC"));
		}
		return authorities;
	}
}
