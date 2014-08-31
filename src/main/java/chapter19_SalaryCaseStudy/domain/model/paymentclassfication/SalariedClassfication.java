package chapter19_SalaryCaseStudy.domain.model.paymentclassfication;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.value.Money;

public class SalariedClassfication implements PaymentClassfication{
	private BigDecimal salary;

	public SalariedClassfication(BigDecimal salary) {
		this.salary = salary;
	}


	public BigDecimal getSalary(){
		return salary; 
	}


	@Override
	public Money calculatePay() {
		return new Money(salary.doubleValue());
	};
}
