package chapter19_SalaryCaseStudy;

import java.util.HashMap;
import java.util.Map;

import chapter19_SalaryCaseStudy.domain.Employee;

public class PayrollDatabase {
	private static Map<Integer,Employee> employees = new HashMap<>();

	public static Employee getEmployee(Integer empId) {
		return employees.get(empId);
	}

	public static void addEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
	}
}
