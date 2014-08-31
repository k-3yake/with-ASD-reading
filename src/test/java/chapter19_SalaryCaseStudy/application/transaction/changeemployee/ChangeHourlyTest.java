package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddCommisionedEmployee;
import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.HourlyClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.WeeklySchedule;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class ChangeHourlyTest {
	@Before
	public void clear(){
		PayrollDatabase.clear();
	}

	@Test
	public void 時給制への変更のテスト() {
		Integer empId = 1;
		new AddCommisionedEmployee(empId, "name", "address", new BigDecimal(0)).execute();
		//実行
		new ChangeHourly(empId,new BigDecimal(1)).exec();
		//検証
		Employee employee = PayrollDatabase.getEmployee(empId);
		assertThat(employee.getPaymentClassfication(), is(instanceOf(HourlyClassfication.class)));
		assertThat(employee.getPaymentSchedule(), is(instanceOf(WeeklySchedule.class)));
	}

}
