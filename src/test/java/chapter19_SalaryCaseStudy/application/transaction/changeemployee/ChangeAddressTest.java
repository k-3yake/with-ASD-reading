package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddHourlyEmployee;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class ChangeAddressTest {
	@Before
	public void clear(){
		PayrollDatabase.clear();
	}

	@Test
	public void アドレス変更のテスト_従業員が存在する場合_アドレスを変更する() throws Exception {
		Integer empId = 1;
		new AddHourlyEmployee(empId, "name", "address",new BigDecimal(0)).execute();
		//実行
		String changedAddress = "changedAdress";
		new ChangeAddress(empId,changedAddress).exec();
		//検証
		assertThat(PayrollDatabase.getEmployee(empId).getAddress(), is(changedAddress));
	}
}