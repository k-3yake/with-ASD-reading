package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymethod.Mail;

public class ChangeMail extends ChangeEmployee{
	private String address;
	
	public ChangeMail(Integer empId, String address) {
		super(empId);
		this.address = address;
	}

	@Override
	protected void change(Employee employee) {
		employee.setPayMethod(new Mail(address));
	}
}