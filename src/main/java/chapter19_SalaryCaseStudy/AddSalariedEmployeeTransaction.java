package chapter19_SalaryCaseStudy;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.MonthlySchedule;
import chapter19_SalaryCaseStudy.domain.SalariedClassfication;

public class AddSalariedEmployeeTransaction extends AbstractAddEmployeeTransaction{
	protected BigDecimal salary;

	public AddSalariedEmployeeTransaction(Integer empId, String name,String addredd, BigDecimal salary) {
		super(empId,name,addredd);
		this.salary = salary;
	}

	@Override
	public MonthlySchedule getSchedule() {
		return new MonthlySchedule();
	}

	@Override
	public SalariedClassfication getPaymentClassfication() {
		return new SalariedClassfication(salary);
	}
}