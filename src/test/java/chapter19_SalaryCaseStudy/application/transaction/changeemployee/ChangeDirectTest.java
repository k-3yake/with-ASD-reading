package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddHourlyEmployee;
import chapter19_SalaryCaseStudy.domain.model.paymethod.Direct;
import chapter19_SalaryCaseStudy.domain.value.Bank;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class ChangeDirectTest {
	@Before
	public void clear(){
		PayrollDatabase.clear();
	}
	
	@Test
	public void 給与直接引き落としへの変更のテスト() throws Exception {
		Integer empId = 1;
		new AddHourlyEmployee(empId,"name","address",new BigDecimal(0)).execute();
		//実行
		new ChangeDirect(empId,new Bank("account1")).exec();
		//検証
		assertThat(PayrollDatabase.getEmployee(empId).getPayMethod(), is(instanceOf(Direct.class)));
	}
}