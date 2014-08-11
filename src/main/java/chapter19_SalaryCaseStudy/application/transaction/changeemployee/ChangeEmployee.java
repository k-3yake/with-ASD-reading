package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.infla.BusinessExcepction;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public abstract class ChangeEmployee {
	private Integer empId;

	public ChangeEmployee(Integer empId) {
		this.empId = empId;
	}

	public void exec() {
		if(PayrollDatabase.getEmployee(empId) == null)
			throw new BusinessExcepction("従業員が存在しません。empId=" + empId);
		Employee employee = PayrollDatabase.getEmployee(empId);
		change(employee);
	}

	protected abstract void change(Employee employee);

}