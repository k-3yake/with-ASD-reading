package chapter19_SalaryCaseStudy.domain.model.affilation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import chapter19_SalaryCaseStudy.domain.model.ServiceCharge;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public class UnionAffilation implements Affilation {
	private BigDecimal dues;
	private Map<DateOnly, ServiceCharge> serviceCharges = new HashMap<>();

	public UnionAffilation(BigDecimal dues) {
		this.dues = dues;
	}
	
	@Override
	public BigDecimal getServiceCharge(DateOnly date) {
		return serviceCharges.get(date).getAmount();
	}

	public void addServiceCharge(ServiceCharge serviceCharge) {
		serviceCharges.put(serviceCharge.getDate(), serviceCharge);
	}
}
