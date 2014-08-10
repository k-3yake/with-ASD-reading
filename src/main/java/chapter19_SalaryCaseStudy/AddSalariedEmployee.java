package chapter19_SalaryCaseStudy;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.MonthlySchedule;
import chapter19_SalaryCaseStudy.domain.PaymentClassfication;
import chapter19_SalaryCaseStudy.domain.PaymentSchedule;
import chapter19_SalaryCaseStudy.domain.SalariedClassfication;

public class AddSalariedEmployee extends AbstractAddEmployeeTransaction{
	protected BigDecimal salary;

	public AddSalariedEmployee(Integer empId, String name,String addredd, BigDecimal salary) {
		super(empId,name,addredd);
		this.salary = salary;
	}

	@Override
	public PaymentSchedule getSchedule() {
		return new MonthlySchedule();
	}

	@Override
	public PaymentClassfication getPaymentClassfication() {
		return new SalariedClassfication(salary);
	}
}