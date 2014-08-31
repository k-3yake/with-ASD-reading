package chapter19_SalaryCaseStudy.domain.model.paymentschedule;

import java.util.Calendar;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;


public class BiweeklySchedule implements PaymentSchedule{

	@Override
	public boolean isPayDate(DateOnly payDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(payDate.toDate());
		if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && (calendar.get(Calendar.WEEK_OF_YEAR)%2 == 1)){
			return true;
		};
		return false;
	}

}
