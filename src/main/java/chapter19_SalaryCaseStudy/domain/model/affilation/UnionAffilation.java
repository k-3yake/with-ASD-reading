package chapter19_SalaryCaseStudy.domain.model.affilation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import chapter19_SalaryCaseStudy.domain.model.ServiceCharge;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.Money;

public class UnionAffilation implements Affilation {
	private BigDecimal dues;
	private Integer memberId;
	private Map<DateOnly, ServiceCharge> serviceCharges = new HashMap<>();

	public UnionAffilation(Integer memberId,BigDecimal dues) {
		this.memberId = memberId;
		this.dues = dues;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public Money getDues() {
		return new Money(dues.doubleValue());
	}

	@Override
	public BigDecimal getServiceCharge(DateOnly date) {
		return serviceCharges.get(date).getAmount();
	}

	public void addServiceCharge(ServiceCharge serviceCharge) {
		serviceCharges.put(serviceCharge.getDate(), serviceCharge);
	}

}