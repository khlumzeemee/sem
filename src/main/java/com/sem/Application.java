package com.sem;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sem.domain.entity.Account;
import com.sem.domain.entity.Customer;
import com.sem.domain.repository.AccountMovementRepository;
import com.sem.domain.repository.AccountRepository;
import com.sem.domain.repository.CustomerRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountMovementRepository accountMovementRepository;

//	@Autowired
//	private UserRepository userRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Customer 1
		Customer customer = customerRepository.save(new Customer("Max","Payne"));
		accountRepository.save(new Account(customer, "Max account", new BigDecimal(500)));
//		userRoleRepository.save(new UserRole(customer.getUser(), "ROLE_USER"));
		
		//Customer 2
		customer = customerRepository.save(new Customer("Jack","Daniels"));
		
		//Account 1
		accountRepository.save(new Account(customer, "Jack account", new BigDecimal(200)));
//		userRoleRepository.save(new UserRole(customer.getUser(), "ROLE_USER"));
		
		//Transfer money
//		accountMovementRepository.
		
	}
}
