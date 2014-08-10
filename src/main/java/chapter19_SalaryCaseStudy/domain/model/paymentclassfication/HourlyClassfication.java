package chapter19_SalaryCaseStudy.domain.model.paymentclassfication;

import java.util.HashMap;
import java.util.Map;

import chapter19_SalaryCaseStudy.domain.model.TimeCard;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public class HourlyClassfication implements PaymentClassfication {
	private Map<DateOnly,TimeCard> timeCards = new HashMap<>();
	
	
	public void addTimeCard(TimeCard timeCard) {
		timeCards.put(timeCard.getDate(),timeCard);
	}

	public TimeCard getTimeCard(DateOnly date) {
		return timeCards.get(date);
	}
}
