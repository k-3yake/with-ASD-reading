package chapter19_SalaryCaseStudy.domain.model.paymentclassfication;

import java.math.BigDecimal;

public class SalariedClassfication implements PaymentClassfication{
	private BigDecimal salary;

	public SalariedClassfication(BigDecimal salary) {
		this.salary = salary;
	}


	public BigDecimal getSalary(){
		return salary; 
	};
}
