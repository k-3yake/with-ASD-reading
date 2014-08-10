package chapter19_SalaryCaseStudy.domain.model;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public class TimeCard {
	private DateOnly date;
	private BigDecimal hours;
	
	public TimeCard(DateOnly date, BigDecimal hours) {
		this.date = date;
		this.hours = hours;
	}

	public DateOnly getDate() {
		return date;
	}

	public BigDecimal hours() {
		return hours;
	}
}
