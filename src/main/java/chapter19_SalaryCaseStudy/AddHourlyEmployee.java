package chapter19_SalaryCaseStudy;

import chapter19_SalaryCaseStudy.domain.HourlyClassfication;
import chapter19_SalaryCaseStudy.domain.PaymentClassfication;
import chapter19_SalaryCaseStudy.domain.PaymentSchedule;
import chapter19_SalaryCaseStudy.domain.WeeklySchedule;

public class AddHourlyEmployee extends AbstractAddEmployeeTransaction{

	public AddHourlyEmployee(Integer empId, String name, String address) {
		super(empId, name, address);
	}

	@Override
	public PaymentSchedule getSchedule() {
		return new WeeklySchedule();
	}

	@Override
	public PaymentClassfication getPaymentClassfication() {
		return new HourlyClassfication();
	}

}
