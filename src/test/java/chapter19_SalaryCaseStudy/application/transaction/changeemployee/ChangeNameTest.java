package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddHourlyEmployee;
import chapter19_SalaryCaseStudy.infla.BusinessExcepction;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class ChangeNameTest {
	@Before
	public void clear(){
		PayrollDatabase.clear();
	}
	
	@Test
	public void 名前変更のテスト_従業員が存在する場合_名前を変更する() throws Exception {
		Integer empId = 1;
		new AddHourlyEmployee(empId, "name", "address",new BigDecimal(0)).execute();
		//実行
		String changetdName = "changedName";
		new ChangeName(empId,changetdName).exec();
		//検証
		assertThat(PayrollDatabase.getEmployee(empId).getName() , is(changetdName));
	}

	@Test(expected=BusinessExcepction.class)
	public void 名前変更のテスト_従業員が存在しない場合_例外を発生させる() throws Exception {
		new ChangeName(1,"changedName").exec();
	}
}
