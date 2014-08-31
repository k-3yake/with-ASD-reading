package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddHourlyEmployee;
import chapter19_SalaryCaseStudy.domain.model.paymethod.HoldMethod;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class ChangeHoldTest {
	@Before
	public void clear(){
		PayrollDatabase.clear();
	}

	@Test
	public void 給与の手渡し払いへの変更のテスト() throws Exception {
		Integer empId = 1;
		new AddHourlyEmployee(empId, "name", "address",new BigDecimal(0)).execute();;
		//実行
		new ChangeHold(empId).exec();
		//検証
		assertThat(PayrollDatabase.getEmployee(empId).getPayMethod(), is(instanceOf(HoldMethod.class)));
	}
}
