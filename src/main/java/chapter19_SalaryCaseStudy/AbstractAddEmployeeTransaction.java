package chapter19_SalaryCaseStudy;

import chapter19_SalaryCaseStudy.domain.Employee;
import chapter19_SalaryCaseStudy.domain.HoldMethod;
import chapter19_SalaryCaseStudy.domain.MonthlySchedule;
import chapter19_SalaryCaseStudy.domain.SalariedClassfication;


public abstract class AbstractAddEmployeeTransaction {
	private Integer empId;
	private String name;
	private String address;

	public AbstractAddEmployeeTransaction(Integer empId, String name,String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	public void execute() {
		Employee employee = new Employee(empId,name);	
		employee.setPaymentClassfication(getPaymentClassfication());
		employee.setPaymentSchedule(getSchedule());
		employee.setPayMethod(new HoldMethod());
		PayrollDatabase.addEmployee(employee);
	}

	public abstract MonthlySchedule getSchedule();
	
	public abstract SalariedClassfication getPaymentClassfication();
}