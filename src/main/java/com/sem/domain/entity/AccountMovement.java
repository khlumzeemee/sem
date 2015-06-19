package com.sem.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class AccountMovement extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4437660782525580528L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private
	Long id;
	
	//Avoid infinite loop with this annotation 
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne (optional=false, fetch = FetchType.LAZY)
	private Account sourceAccount;

	//Avoid infinite loop with this annotation 
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne (optional=false, fetch = FetchType.LAZY)
	private Account destinationAccount;
	
	@NotNull
	private BigDecimal amount;
	
	@NotNull
	private Date movementDate;
	
	public AccountMovement() {
	}
	

	public AccountMovement(Account sourceAccount, Account destinationAccount,
			BigDecimal amount) {
		super();
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.amount = amount;
		this.movementDate = Calendar.getInstance().getTime();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public Account getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(Account destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Source account:"+getSourceAccount().getAccountNo() +  ", destination account:"+getDestinationAccount().getAccountNo() + ", transfer amount:"+getAmount();
	}
	
	
	
}
