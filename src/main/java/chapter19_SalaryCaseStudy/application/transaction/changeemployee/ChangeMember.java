package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.affilation.UnionAffilation;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class ChangeMember extends ChangeEmployee{
	private Integer memberId;
	private BigDecimal dues;

	public ChangeMember(Integer empId, Integer memberId, BigDecimal dues) {
		super(empId);
		this.memberId = memberId;
		this.dues = dues;
	}

	@Override
	protected void change(Employee employee) {
		if(PayrollDatabase.getUnionMember(memberId) != null){
			
		}
		PayrollDatabase.addUnionMember(memberId, employee);
		employee.setAffilation(new UnionAffilation(memberId,dues));
	}
}