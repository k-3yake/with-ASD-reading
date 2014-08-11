package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.affilation.Affilation;
import chapter19_SalaryCaseStudy.domain.model.affilation.NoAffilation;
import chapter19_SalaryCaseStudy.domain.model.affilation.UnionAffilation;
import chapter19_SalaryCaseStudy.infla.BusinessExcepction;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class ChangeUnaffilated extends ChangeEmployee{

	public ChangeUnaffilated(Integer empId) {
		super(empId);
	}

	@Override
	protected void change(Employee employee) {
		Affilation affilation = employee.getAffilation();
		if(!(affilation instanceof UnionAffilation) 
				|| PayrollDatabase.getUnionMember(((UnionAffilation)affilation).getMemberId()) == null){
			throw new BusinessExcepction("組合員ではありません。empId=" + employee.getId());
		}
		Integer memberId = ((UnionAffilation)affilation).getMemberId();		
		PayrollDatabase.deleteUnionMember(memberId);
		employee.setAffilation(new NoAffilation());
	}
}