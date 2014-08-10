package chapter19_SalaryCaseStudy;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.BiweeklySchedule;
import chapter19_SalaryCaseStudy.domain.MonthlySchedule;
import chapter19_SalaryCaseStudy.domain.PaymentSchedule;
import chapter19_SalaryCaseStudy.domain.SalariedClassfication;

public class AddCommisionedEmployee extends AbstractAddEmployeeTransaction{
	private BigDecimal salary;
	
	public AddCommisionedEmployee(Integer empId,String name,String address,BigDecimal salary) {
		super(empId, name, address);
		this.salary = salary;
	}

	@Override
	public PaymentSchedule getSchedule() {
		return new BiweeklySchedule();
	}

	@Override
	public SalariedClassfication getPaymentClassfication() {
		return new CommistonedClassfication(salary);
	}
	

}
