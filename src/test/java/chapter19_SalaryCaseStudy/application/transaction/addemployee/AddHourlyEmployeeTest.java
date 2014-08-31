package chapter19_SalaryCaseStudy.application.transaction.addemployee;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Test;

import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.HourlyClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.WeeklySchedule;
import chapter19_SalaryCaseStudy.domain.model.paymethod.HoldMethod;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

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
		AddHourlyEmployee transaction = new AddHourlyEmployee(empId,name,"Home",new BigDecimal(0));
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