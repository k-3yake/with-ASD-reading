package chapter19_SalaryCaseStudy.domain.value;

import java.util.Calendar;
import java.util.Date;

public class DateOnly {
	private Integer year;
	private Integer month;
	private Integer date;

	public DateOnly(Integer year, Integer month, Integer date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}
	
	public Date toDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH,month - 1);
		calendar.set(Calendar.DATE, date);
		return calendar.getTime();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateOnly other = (DateOnly) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
}