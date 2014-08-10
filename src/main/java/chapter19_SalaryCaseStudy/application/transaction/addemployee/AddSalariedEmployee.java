package chapter19_SalaryCaseStudy.application.transaction.addemployee;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.PaymentClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.SalariedClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.MonthlySchedule;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.PaymentSchedule;

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