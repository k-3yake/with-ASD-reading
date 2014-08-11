package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.SalariedClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.MonthlySchedule;

public class ChangeSalaried extends ChangeClassfication{
	private BigDecimal salary;

	public ChangeSalaried(Integer empId, BigDecimal salary) {
		super(empId);
		this.salary = salary;
	}

	@Override
	protected void changePaymetnClassfication(Employee employee) {
		employee.setPaymentClassfication(new SalariedClassfication(salary));
	}

	@Override
	protected void changePaymentSchedule(Employee employee) {
		employee.setPaymentSchedule(new MonthlySchedule());
	}
}