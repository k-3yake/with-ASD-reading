package chapter19_SalaryCaseStudy;

import java.util.HashMap;
import java.util.Map;

import chapter19_SalaryCaseStudy.domain.Employee;

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
		return unionMembers.get(memberId);
	}

}
