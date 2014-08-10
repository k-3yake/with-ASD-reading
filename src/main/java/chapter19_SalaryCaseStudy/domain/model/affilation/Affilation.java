package chapter19_SalaryCaseStudy.domain.model.affilation;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public interface Affilation {

	BigDecimal getServiceCharge(DateOnly date);

	


}
