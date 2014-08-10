package chapter19_SalaryCaseStudy.domain.model;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public class ServiceCharge {
	private DateOnly date;
	private BigDecimal amount;

	public ServiceCharge(DateOnly date, BigDecimal amount) {
		this.date = date;
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public DateOnly getDate() {
		return date;
	}
}