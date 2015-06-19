package com.sem.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sem.domain.entity.Account;

@RepositoryRestResource(exported=false)
public interface AccountRepository extends PagingAndSortingRepository<Account, Long>{
	
	/**
	 * Find by customer.user.userName
	 * http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-property-expressions
	 * @param user
	 * @return
	 */
//	List<Account> findByCustomerUserUserName(@Param("userName") String userName);
}
