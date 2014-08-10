package chapter19_SalaryCaseStudy;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.ServiceCharge;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public interface Affilation {

	BigDecimal getServiceCharge(DateOnly date);

	


}
