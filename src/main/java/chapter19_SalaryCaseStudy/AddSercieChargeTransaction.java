package chapter19_SalaryCaseStudy;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.Employee;
import chapter19_SalaryCaseStudy.domain.ServiceCharge;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.infla.BusinessExcepction;

public class AddSercieChargeTransaction {
	private Integer memberId;
	private DateOnly dateOnly;
	private BigDecimal amount;


	public AddSercieChargeTransaction(Integer memberId, DateOnly dateOnly,	BigDecimal amount) {
		this.memberId = memberId;
		this.dateOnly = dateOnly;
		this.amount = amount;
	}


	public void exec() {
		if(PayrollDatabase.getUnionMember(memberId) == null)
			throw new BusinessExcepction("組合員が存在しません。memberId = " + memberId);
		if(!(PayrollDatabase.getUnionMember(memberId).getAffilation() instanceof UnionAffilation))
			throw new BusinessExcepction("組合員ではありません。memberId = " + memberId);
		UnionAffilation affilation = (UnionAffilation) PayrollDatabase.getUnionMember(memberId).getAffilation();
		affilation.addServiceCharge(new ServiceCharge(dateOnly,amount));
	}
}