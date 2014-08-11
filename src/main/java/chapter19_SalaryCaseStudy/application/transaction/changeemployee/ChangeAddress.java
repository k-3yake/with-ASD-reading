package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import chapter19_SalaryCaseStudy.domain.model.Employee;

public class ChangeAddress extends ChangeEmployee{
	private String changedAddress;

	public ChangeAddress(Integer empId, String changedAddress) {
		super(empId);
		this.changedAddress = changedAddress;
	}
	
	@Override
	protected void change(Employee employee) {
		employee.setAddress(changedAddress);
	}
}