package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.HourlyClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.WeeklySchedule;

public class ChangeHourly extends ChangeClassfication{
	private BigDecimal rate;

	public ChangeHourly(Integer empId,BigDecimal rate) {
		super(empId);
		this.rate = rate;
	}
	
	@Override
	protected void changePaymetnClassfication(Employee employee) {
		employee.setPaymentClassfication(new HourlyClassfication(rate));
	}

	@Override
	protected void changePaymentSchedule(Employee employee) {
		employee.setPaymentSchedule(new WeeklySchedule());
	}


}