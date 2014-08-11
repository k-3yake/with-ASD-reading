package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddHourlyEmployee;
import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.CommistonedClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.BiweeklySchedule;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class ChangeCommissionedTest {
	@Before
	public void clear(){
		PayrollDatabase.clear();
	}

	@Test
	public void 歩合制への変更のテスト() throws Exception {
		Integer empId = 1;
		new AddHourlyEmployee(empId, "name", "address").execute();
		//実行
		BigDecimal salary = new BigDecimal(2);
		new ChangeCommissioned(empId,salary).exec();;
		//検証
		Employee employee = PayrollDatabase.getEmployee(empId);
		assertThat(((CommistonedClassfication)employee.getPaymentClassfication()).getSalary(), is(salary));
		assertThat(employee.getPaymentSchedule(), is(instanceOf(BiweeklySchedule.class)));
	}
}
