package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddCommisionedEmployee;
import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.SalariedClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.MonthlySchedule;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class ChangeSalariedTest {
	@Before
	public void clear(){
		PayrollDatabase.clear();
	}

	@Test
	public void 月給制への変更のテスト() {
		Integer empId = 1;
		new AddCommisionedEmployee(empId, "name", "address", new BigDecimal(0)).execute();
		//実行
		BigDecimal salary = new BigDecimal(100);
		new ChangeSalaried(empId,salary).exec();
		//検証
		Employee employee = PayrollDatabase.getEmployee(empId);
		assertThat(((SalariedClassfication)employee.getPaymentClassfication()).getSalary(), is(salary));
		assertThat(employee.getPaymentSchedule(), is(instanceOf(MonthlySchedule.class)));
	}

}
