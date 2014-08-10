package chapter19_SalaryCaseStudy.application.transaction;

import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class DeleteEmployeeTransaction {
	Integer empId;
	
	public DeleteEmployeeTransaction(Integer empId) {
		this.empId = empId;
	}

	public void exec() {
		PayrollDatabase.delete(empId);
		
	}

}
