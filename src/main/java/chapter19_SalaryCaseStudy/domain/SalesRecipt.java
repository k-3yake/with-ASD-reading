package chapter19_SalaryCaseStudy.domain;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public class SalesRecipt {
	private DateOnly date;
	private BigDecimal amount;


	public SalesRecipt(DateOnly date, BigDecimal amount) {
		this.date = date;
		this.amount = amount;
	}

	public DateOnly getDate() {
		return date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

}
