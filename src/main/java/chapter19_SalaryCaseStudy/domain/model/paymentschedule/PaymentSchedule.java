package chapter19_SalaryCaseStudy.domain.model.paymentschedule;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public interface PaymentSchedule {

	boolean isPayDate(DateOnly payDate);

}
