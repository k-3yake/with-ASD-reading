package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import chapter19_SalaryCaseStudy.domain.model.Employee;

public abstract class ChangeClassfication extends ChangeEmployee{

	public ChangeClassfication(Integer empId) {
		super(empId);
	}

	@Override
	protected void change(Employee employee) {
		changePaymetnClassfication(employee);
		changePaymentSchedule(employee);
	}

	protected abstract void changePaymetnClassfication(Employee employee);

	protected abstract void changePaymentSchedule(Employee employee);
}