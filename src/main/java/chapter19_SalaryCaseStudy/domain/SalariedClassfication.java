package chapter19_SalaryCaseStudy.domain;

import java.math.BigDecimal;

public class SalariedClassfication implements PaymentClassfication{
	private BigDecimal salary;

	public SalariedClassfication(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public BigDecimal getSalary(){
		return salary; 
	};

}
