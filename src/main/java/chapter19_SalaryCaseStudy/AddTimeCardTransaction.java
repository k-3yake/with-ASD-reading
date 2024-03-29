package chapter19_SalaryCaseStudy;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.Employee;
import chapter19_SalaryCaseStudy.domain.HourlyClassfication;
import chapter19_SalaryCaseStudy.domain.PaymentClassfication;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.TimeCard;
import chapter19_SalaryCaseStudy.infla.BusinessExcepction;

public class AddTimeCardTransaction {
	private Integer empId;
	private DateOnly date;
	private BigDecimal hours;

	public AddTimeCardTransaction(Integer empId, DateOnly date, BigDecimal hours) {
		this.empId = empId;
		this.date = date;
		this.hours = hours;
	}

	public void exec() {
		if(PayrollDatabase.getEmployee(empId) == null) 
			throw new BusinessExcepction("従業員がいません。empId=" + empId);
		if(!(PayrollDatabase.getEmployee(empId).getPaymentClassfication() instanceof HourlyClassfication))
			throw new BusinessExcepction("時給制の従業員ではありません。empId=" + empId);
		HourlyClassfication hourlyClassfication = (HourlyClassfication)PayrollDatabase.getEmployee(empId).getPaymentClassfication();
		hourlyClassfication.addTimeCard(new TimeCard(date, hours));
	}
}