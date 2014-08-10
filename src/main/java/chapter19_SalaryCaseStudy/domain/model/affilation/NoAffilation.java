package chapter19_SalaryCaseStudy.domain.model.affilation;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public class NoAffilation implements Affilation {

	@Override
	public BigDecimal getServiceCharge(DateOnly date) {
		return new BigDecimal(0);
	}

}
