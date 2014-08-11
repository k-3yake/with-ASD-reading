package chapter19_SalaryCaseStudy.application.transaction.addemployee;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.PaymentClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.PaymentSchedule;
import chapter19_SalaryCaseStudy.domain.model.paymethod.HoldMethod;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;


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
		Employee employee = new Employee(empId);
		employee.setName(name);
		employee.setAddress(address);
		employee.setPaymentClassfication(getPaymentClassfication());
		employee.setPaymentSchedule(getSchedule());
		employee.setPayMethod(new HoldMethod());
		PayrollDatabase.addEmployee(employee);
	}

	public abstract PaymentSchedule getSchedule();
	
	public abstract PaymentClassfication getPaymentClassfication();
}