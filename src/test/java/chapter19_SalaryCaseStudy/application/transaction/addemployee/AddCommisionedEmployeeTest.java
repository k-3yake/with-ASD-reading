package chapter19_SalaryCaseStudy.application.transaction.addemployee;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Test;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.CommistonedClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.BiweeklySchedule;
import chapter19_SalaryCaseStudy.domain.model.paymethod.HoldMethod;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class AddCommisionedEmployeeTest {

	@After
	public void clear(){
		PayrollDatabase.clear();
	}
	
	@Test
	public void 歩合制従業員追加のテスト() {
		//準備
		Integer empId = 1;
		String name = "Bob";
		BigDecimal salary = new BigDecimal(1000.00);
		AddCommisionedEmployee transaction = new AddCommisionedEmployee(empId,name,"Home",salary);
		//実行
		transaction.execute();
		//検証
		Employee addedEmployee = PayrollDatabase.getEmployee(empId);
		assertThat(addedEmployee, is(notNullValue()));
		assertThat(addedEmployee.getName(), is(name));
		assertThat(addedEmployee.getPaymentClassfication(), is(instanceOf(CommistonedClassfication.class)));
		assertThat(((CommistonedClassfication)addedEmployee.getPaymentClassfication()).getSalary(), is(salary));
		assertThat(addedEmployee.getPaymentSchedule(), is(instanceOf(BiweeklySchedule.class)));
		assertThat(addedEmployee.getPayMethod(), is(instanceOf(HoldMethod.class)));
	}
}