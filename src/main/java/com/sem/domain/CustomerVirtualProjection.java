package com.sem.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.sem.domain.entity.Customer;

@Projection(name = "virtualCustomer", types = { Customer.class })
public interface CustomerVirtualProjection {

  @Value("#{target.firstName} #{target.lastName}") 
  String getFullName();
}
