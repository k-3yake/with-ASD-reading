package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.HourlyClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.WeeklySchedule;

public class ChangeHourly extends ChangeClassfication{

	public ChangeHourly(Integer empId) {
		super(empId);
	}
	
	@Override
	protected void changePaymetnClassfication(Employee employee) {
		employee.setPaymentClassfication(new HourlyClassfication());
	}

	@Override
	protected void changePaymentSchedule(Employee employee) {
		employee.setPaymentSchedule(new WeeklySchedule());
	}


}