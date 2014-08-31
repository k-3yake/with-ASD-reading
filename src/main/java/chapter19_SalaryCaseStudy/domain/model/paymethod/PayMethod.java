package chapter19_SalaryCaseStudy.domain.model.paymethod;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.PayCheck;

public abstract class PayMethod {
	private PayCheck payCheck;

	public PayCheck getPayCheck() {
		return payCheck;
	}

	public void setPayCheck(PayCheck payCheck) {
		this.payCheck = payCheck;
	}
}