package com.sem.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sem.domain.entity.Account;
import com.sem.domain.entity.AccountMovement;
import com.sem.domain.repository.AccountMovementRepository;
import com.sem.domain.repository.AccountRepository;

@RestController
public class MoneyTransferController {
	
	@Autowired
	private AccountMovementRepository repository;
	@Autowired
	private AccountRepository accountRepository;
	
	/**
	 * Transfer money between two accounts
	 * Spring validator: http://www.leveluplunch.com/java/tutorials/017-validate-spring-rest-webservice-request/
	 * @param moneyTransferDTOIn
	 * @return
	 * @throws Exception
	 */
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/transfer", method=RequestMethod.POST)
	List<AccountMovement> transferMoneyBetweenAccountsWithObjects(@Valid @RequestBody(required=true) MoneyTransferDTOInput moneyTransferDTOIn) throws Exception{
		
		//Validate accounts
		Account sourceAccount = accountRepository.findOne(moneyTransferDTOIn.getSourceAccountNo());
		if(sourceAccount == null)
			throw new Exception("Source account not found");
		
		Account destinationAccount = accountRepository.findOne(moneyTransferDTOIn.getDestinationAccountNo());
		if(destinationAccount == null)
			throw new Exception("Destination account not found");
		
		if(sourceAccount.equals(destinationAccount))
			throw new Exception("Source and destination accounts must be different");
		
		List<AccountMovement> accountMovements = new ArrayList<AccountMovement>();
		AccountMovement sourceMovement = new AccountMovement(sourceAccount, destinationAccount, moneyTransferDTOIn.getAmount().negate());
		repository.save(sourceMovement);
		
		AccountMovement destinationMovement = new AccountMovement(destinationAccount, sourceAccount, moneyTransferDTOIn.getAmount());
		repository.save(destinationMovement);
		
		accountMovements.add(sourceMovement);
		accountMovements.add(destinationMovement);
		
		return accountMovements;
	}
	
	@RequestMapping(value="/my/accounts", method=RequestMethod.GET)
	List<Account> getCurrentUserAccounts(){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();		
		return accountRepository.findByCustomerUserUserName(userName);
	}
	
}
