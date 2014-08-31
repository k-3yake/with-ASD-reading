package chapter19_SalaryCaseStudy.domain.value;

import java.math.BigDecimal;



public class Hours {
	private BigDecimal val;
	
	public Hours(Integer hours){
		this.val = new BigDecimal(hours); 
	}
	
	public Hours(Double hours){
		this.val = new BigDecimal(hours.toString());
	}
	
	public Boolean moreThan(Hours arg) {
		return this.val.compareTo(arg.val) > 0;
	}

	public Hours substract(Hours arg) {
		return new Hours(val.subtract(arg.val).doubleValue());
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
		Hours other = (Hours) obj;
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (val.compareTo(other.val) != 0)
			return false;
		return true;
	}

	public BigDecimal bigDecimal() {
		return val;
	}
}