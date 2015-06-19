package com.sem.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Customer extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1402470190142093279L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerNo;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@JsonBackReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany (mappedBy="customer", fetch = FetchType.LAZY)
	private List<Account> accounts;
	
	
//	@JsonManagedReference
//	@OneToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.PERSIST)
//	private User user;
	
	public Customer() {
	}
	
	
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
//		//Create user
//		Collection<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
//		GrantedAuthority a = new SimpleGrantedAuthority("USER");
//		authority.add(a);
//		this.user = new User( firstName.toUpperCase() + lastName.toUpperCase(), firstName.toUpperCase() + lastName.toUpperCase(), authority);
	}

	public Long getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(Long customerNo) {
		this.customerNo = customerNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return "Customer no:"+ getCustomerNo() + ", name: "+ getFirstName() +" " + getLastName();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerNo == null) ? 0 : customerNo.hashCode());
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
		Customer other = (Customer) obj;
		if (customerNo == null) {
			if (other.customerNo != null)
				return false;
		} else if (!customerNo.equals(other.customerNo))
			return false;
		return true;
	}

//	public User getUser() {
//		return user;
//	}
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}
}
