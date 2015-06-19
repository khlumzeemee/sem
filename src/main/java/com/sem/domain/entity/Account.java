package com.sem.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Account extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -665110402966579311L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountNo;
	
	@NotNull @NotEmpty
	@Length(max=50)
	private String accountName;

	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(optional = false, fetch=FetchType.LAZY)
	private Customer customer;

	@NotNull
	private BigDecimal balance;
	
	@JsonBackReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy="sourceAccount")
	private List<AccountMovement> accountMovements;
	
	@Version
	@JsonIgnore
	private
	int version;

	public Account() {
	}
	
	public Account(Customer customer, String accountName, BigDecimal balance) {
		super();
		this.customer = customer;
		this.balance = balance;
		this.accountName = accountName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account:" + getAccountNo() + " (customer: " + getCustomer()
				+ ") balance:" + getBalance();
	}

	public int getVersion() {
		return version;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public List<AccountMovement> getAccountMovements() {
		return accountMovements;
	}

	public void setAccountMovements(List<AccountMovement> accountMovements) {
		this.accountMovements = accountMovements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountNo == null) ? 0 : accountNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}
	
	
}
