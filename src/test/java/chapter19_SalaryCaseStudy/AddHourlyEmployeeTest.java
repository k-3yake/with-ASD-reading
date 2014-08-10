package chapter19_SalaryCaseStudy;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Test;

import chapter19_SalaryCaseStudy.domain.Employee;
import chapter19_SalaryCaseStudy.domain.HoldMethod;
import chapter19_SalaryCaseStudy.domain.HourlyClassfication;
import chapter19_SalaryCaseStudy.domain.WeeklySchedule;

public class AddHourlyEmployeeTest {

	@After
	public void clear(){
		PayrollDatabase.clear();
	}
	
	@Test
	public void 時給制従業員追加のテスト() {
		//準備
		Integer empId = 1;
		String name = "Bob";
		AddHourlyEmployee transaction = new AddHourlyEmployee(empId,name,"Home");
		//実行
		transaction.execute();
		//検証
		Employee addedEmployee = PayrollDatabase.getEmployee(empId);
		assertThat(addedEmployee, is(notNullValue()));
		assertThat(addedEmployee.getName(), is(name));
		assertThat(addedEmployee.getPaymentClassfication(), is(instanceOf(HourlyClassfication.class)));
		assertThat(addedEmployee.getPaymentSchedule(), is(instanceOf(WeeklySchedule.class)));
		assertThat(addedEmployee.getPayMethod(), is(instanceOf(HoldMethod.class)));
	}
}