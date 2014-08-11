package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.CommistonedClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.BiweeklySchedule;

public class ChangeCommissioned extends ChangeClassfication{
	private BigDecimal salary;

	public ChangeCommissioned(Integer empId, BigDecimal salary) {
		super(empId);
		this.salary = salary;
	}

	@Override
	protected void changePaymetnClassfication(Employee employee) {
		employee.setPaymentClassfication(new CommistonedClassfication(salary));
	}

	@Override
	protected void changePaymentSchedule(Employee employee) {
		employee.setPaymentSchedule(new BiweeklySchedule());
	}
}