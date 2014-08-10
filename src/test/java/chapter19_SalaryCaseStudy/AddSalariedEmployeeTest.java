package chapter19_SalaryCaseStudy;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Test;

import chapter19_SalaryCaseStudy.domain.Employee;
import chapter19_SalaryCaseStudy.domain.HoldMethod;
import chapter19_SalaryCaseStudy.domain.MonthlySchedule;
import chapter19_SalaryCaseStudy.domain.SalariedClassfication;

public class AddSalariedEmployeeTest {

	@After
	public void clear(){
		PayrollDatabase.clear();
	}

	@Test
	public void 月給従業員追加のテスト() {
		//準備
		int empId = 1;
		String name = "Bob";
		BigDecimal salary = new BigDecimal(1000.00);
		AddSalariedEmployee transaction = new AddSalariedEmployee(empId,name,"Home",salary);
		//実行
		transaction.execute();
		//検証
		Employee addedEmployee = PayrollDatabase.getEmployee(empId);
		assertThat(addedEmployee, is(notNullValue()));
		assertThat(addedEmployee.getName(), is(name));
		assertThat(addedEmployee.getPaymentClassfication(), is(instanceOf(SalariedClassfication.class)));
		assertThat(((SalariedClassfication)addedEmployee.getPaymentClassfication()).getSalary(), is(salary));
		assertThat(addedEmployee.getPaymentSchedule(), is(instanceOf(MonthlySchedule.class)));
		assertThat(addedEmployee.getPayMethod(), is(instanceOf(HoldMethod.class)));
	}

}