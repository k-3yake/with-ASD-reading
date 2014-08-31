package chapter19_SalaryCaseStudy.domain.value;

import java.math.BigDecimal;

public class Rate {
	private BigDecimal val;

	public Rate(BigDecimal val) {
		this.val = val;
	}

	public BigDecimal multiply(Hours hours) {
		return val.multiply(hours.bigDecimal());
	}
}