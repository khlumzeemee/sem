package com.sem.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

import com.sem.domain.entity.AccountMovement;

@RepositoryRestResource(exported=false)
public interface AccountMovementRepository extends PagingAndSortingRepository<AccountMovement, Long>{ 	
}
