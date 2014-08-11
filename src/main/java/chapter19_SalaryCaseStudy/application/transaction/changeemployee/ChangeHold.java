package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymethod.HoldMethod;

public class ChangeHold extends ChangeEmployee{

	public ChangeHold(Integer empId) {
		super(empId);
	}

	@Override
	protected void change(Employee employee) {
		employee.setPayMethod(new HoldMethod());
	}
}