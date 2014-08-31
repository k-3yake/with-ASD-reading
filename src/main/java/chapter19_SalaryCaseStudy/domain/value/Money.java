package chapter19_SalaryCaseStudy.domain.value;

import java.math.BigDecimal;

public class Money {
	private final BigDecimal val; 

	public Money(Integer val) {
		this.val = new BigDecimal(val);
	}

	public Money(Double val) {
		this.val = new BigDecimal(val.toString());
	}
	
	public Money subtract(Money other) {
		return new Money(this.val.subtract(other.val).doubleValue());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((val == null) ? 0 : val.hashCode());
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
		Money other = (Money) obj;
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (val.compareTo(other.val) != 0)
			return false;
		return true;
	}

	@Deprecated
	public BigDecimal getVal() {
		return val;
	}

}