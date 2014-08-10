package chapter19_SalaryCaseStudy;

public class DeleteEmployeeTransaction {
	Integer empId;
	
	public DeleteEmployeeTransaction(Integer empId) {
		this.empId = empId;
	}

	public void exec() {
		PayrollDatabase.delete(empId);
		
	}

}
