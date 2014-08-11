package chapter19_SalaryCaseStudy.infla;

import java.util.HashMap;
import java.util.Map;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.affilation.UnionAffilation;

public class PayrollDatabase {
	private static Map<Integer,Employee> employees = new HashMap<>();
	private static Map<Integer,Employee> unionMembers = new HashMap<>();

	public static Employee getEmployee(Integer empId) {
		return employees.get(empId);
	}

	public static void addEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
	}
	
	public static void clear(){
		employees = new HashMap<>();
		unionMembers = new HashMap<>();
	}

	public static void delete(Integer empId) {
		employees.remove(empId);
		
	}

	public static void addUnionMember(Integer memberId, Employee employee) {
		unionMembers.put(memberId, employee);
	}

	public static Employee getUnionMember(Integer memberId) {
		Employee employee = unionMembers.get(memberId);
		if(employee == null) return null;
		if(!(employee.getAffilation() instanceof UnionAffilation))
			throw new RuntimeException("組合員以外の従業員が登録されています。memberId="+ memberId);
		return employee;
	}

	public static void deleteUnionMember(Integer memberId) {
//		if(!unionMembers.containsKey(memberId)){
//			throw new RuntimeException("組合員に登録されていんません。memberId="+ memberId);
//		}
		unionMembers.remove(memberId);
	}
}