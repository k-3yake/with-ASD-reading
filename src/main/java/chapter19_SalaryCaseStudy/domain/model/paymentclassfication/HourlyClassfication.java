package chapter19_SalaryCaseStudy.domain.model.paymentclassfication;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import chapter19_SalaryCaseStudy.domain.model.TimeCard;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.Money;
import chapter19_SalaryCaseStudy.domain.value.Rate;

public class HourlyClassfication implements PaymentClassfication {
	private Rate normalRate;
	private Rate overTimeRate;
	private Map<DateOnly,TimeCard> timeCards = new HashMap<>();
	
	
	public HourlyClassfication(BigDecimal rate) {
		this.normalRate = new Rate(rate);
		this.overTimeRate = new Rate(rate.multiply(new BigDecimal("1.5")));
	}

	public void addTimeCard(TimeCard timeCard) {
		timeCards.put(timeCard.getDate(),timeCard);
	}

	public TimeCard getTimeCard(DateOnly date) {
		return timeCards.get(date);
	}

	@Override
	public Money calculatePay() {
		BigDecimal result = new BigDecimal(0);
		for (TimeCard timeCard : timeCards.values()) {
			result = result.add(normalRate.multiply(timeCard.normalTimes()));	
			result = result.add(overTimeRate.multiply(timeCard.overTimes()));
		}
		return new Money(result.doubleValue());
	}
}
