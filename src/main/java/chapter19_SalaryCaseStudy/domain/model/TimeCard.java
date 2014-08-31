package chapter19_SalaryCaseStudy.domain.model;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.Hours;

public class TimeCard {
	private final Hours overTimeBase = new Hours(8);
	private final Hours normalTimes;
	private final Hours overTimes;
	private DateOnly date;
	
	public TimeCard(DateOnly date, Hours workedHours) {
		this.date = date;
		if(workedHours.moreThan(overTimeBase)){
			this.overTimes = workedHours.substract(overTimeBase);
			this.normalTimes = overTimeBase;
		}else{
			this.normalTimes = workedHours;
			this.overTimes = new Hours(0);
		}
	}

	public DateOnly getDate() {
		return date;
	}

	public Hours normalTimes() {
		return normalTimes;
	}

	public Hours overTimes() {
		return overTimes;
	}
}
