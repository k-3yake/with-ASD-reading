package chapter19_SalaryCaseStudy.domain;

import java.util.HashMap;
import java.util.Map;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.TimeCard;

public class HourlyClassfication implements PaymentClassfication {
	private Map<DateOnly,TimeCard> timeCards = new HashMap<>();
	
	
	public void addTimeCard(TimeCard timeCard) {
		timeCards.put(timeCard.getDate(),timeCard);
	}

	public TimeCard getTimeCard(DateOnly date) {
		return timeCards.get(date);
	}
}
