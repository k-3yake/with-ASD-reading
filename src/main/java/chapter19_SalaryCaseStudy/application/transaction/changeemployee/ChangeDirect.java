package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymethod.Direct;
import chapter19_SalaryCaseStudy.domain.value.Bank;

public class ChangeDirect extends ChangeEmployee{
	private Bank bank;

	public ChangeDirect(Integer empId, Bank bank) {
		super(empId);
		this.bank = bank;
	}

	@Override
	protected void change(Employee employee) {
		employee.setPayMethod(new Direct(bank));
	}
}