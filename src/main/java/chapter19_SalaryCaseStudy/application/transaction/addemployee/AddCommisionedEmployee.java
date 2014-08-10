package chapter19_SalaryCaseStudy.application.transaction.addemployee;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.CommistonedClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.SalariedClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.BiweeklySchedule;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.PaymentSchedule;

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
