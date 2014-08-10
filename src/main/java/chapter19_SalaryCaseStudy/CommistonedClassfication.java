package chapter19_SalaryCaseStudy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import chapter19_SalaryCaseStudy.domain.PaymentClassfication;
import chapter19_SalaryCaseStudy.domain.SalariedClassfication;
import chapter19_SalaryCaseStudy.domain.SalesRecipt;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public class CommistonedClassfication extends SalariedClassfication implements PaymentClassfication{
	private Map<DateOnly, SalesRecipt> salesRecipts = new HashMap<>();
	
	public CommistonedClassfication(BigDecimal salary) {
		super(salary);
	}

	public SalesRecipt getSalesRecipt(DateOnly date) {
		return salesRecipts.get(date);
	}

	public void addSalesRecipt(SalesRecipt salesRecipt) {
		salesRecipts.put(salesRecipt.getDate(),salesRecipt);
		
	}
}
