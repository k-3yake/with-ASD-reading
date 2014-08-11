package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import chapter19_SalaryCaseStudy.domain.model.Employee;


public class ChangeName extends ChangeEmployee{
	private String changetdName;

	public ChangeName(Integer empId, String changetdName) {
		super(empId);
		this.changetdName = changetdName;
	}

	@Override
	protected void change(Employee employee) {
		employee.setName(changetdName);
	};
}