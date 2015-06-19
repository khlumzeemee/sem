package com.sem.service;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author AllenSooredoo
 *
 */
public class MoneyTransferDTOInput {
	
	@NotNull @Min(value=0)
	private Long sourceAccountNo;
	@NotNull @Min(value=0)
	private Long destinationAccountNo;
	@NotNull @Min(value=1)
	private BigDecimal amount;
	
	public Long getSourceAccountNo() {
		return sourceAccountNo;
	}
	
	public void setSourceAccountNo(Long sourceAccountNo) {
		this.sourceAccountNo = sourceAccountNo;
	}
	public Long getDestinationAccountNo() {
		return destinationAccountNo;
	}
	
	public void setDestinationAccountNo(Long destinationAccountNo) {
		this.destinationAccountNo = destinationAccountNo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
