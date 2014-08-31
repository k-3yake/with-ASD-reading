package chapter19_SalaryCaseStudy;

import java.util.Set;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.affilation.Affilation;
import chapter19_SalaryCaseStudy.domain.model.affilation.UnionAffilation;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.Money;
import chapter19_SalaryCaseStudy.domain.value.PayCheck;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class Payday {
	private DateOnly payDate;

	public Payday(DateOnly payDate) {
		this.payDate = payDate;
	}

	public void exec() {
		Set<Integer> allEmployee = PayrollDatabase.getAllEmployeeId();
		for (Integer empId : allEmployee) {
			Employee employee = PayrollDatabase.getEmployee(empId);
			if(!employee.isPaydate(payDate)){
				continue;
			}else{
				Money salary = employee.salary();
				Affilation affilation = employee.getAffilation();
				PayCheck payCheck = null;
				if(affilation instanceof UnionAffilation){
					payCheck = new PayCheck(salary.subtract(((UnionAffilation)affilation).getDues()), payDate);
				}else{
					payCheck = new PayCheck(salary, payDate);
				}
				employee.getPayMethod().setPayCheck(payCheck);
				PayrollDatabase.addPaycheck(empId,payCheck);
			}
		}
	}
}