package chapter19_SalaryCaseStudy.application.transaction.addemployee;

import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.HourlyClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.PaymentClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.PaymentSchedule;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.WeeklySchedule;

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
