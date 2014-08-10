package chapter19_SalaryCaseStudy.application.transaction;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.model.ServiceCharge;
import chapter19_SalaryCaseStudy.domain.model.affilation.UnionAffilation;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.infla.BusinessExcepction;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;


public class AddServiceChargeTransaction {
	private Integer memberId;
	private DateOnly date;
	private BigDecimal serviceChargeAmount;


	public AddServiceChargeTransaction(Integer memberId, DateOnly date,BigDecimal serviceChargeAmount) {
		this.memberId = memberId;
		this.date = date;
		this.serviceChargeAmount = serviceChargeAmount;
	}


	public void exec() {
		if(PayrollDatabase.getUnionMember(memberId) == null)
			throw new BusinessExcepction("組合員が存在しません。memberId=" + memberId);
		UnionAffilation unionAffilation = (UnionAffilation)PayrollDatabase.getUnionMember(memberId).getAffilation();
		unionAffilation.addServiceCharge(new ServiceCharge(date, serviceChargeAmount));
	}
}
