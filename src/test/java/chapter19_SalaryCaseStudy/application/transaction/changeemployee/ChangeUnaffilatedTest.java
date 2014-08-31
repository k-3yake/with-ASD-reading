package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddHourlyEmployee;
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeUnaffilated;
import chapter19_SalaryCaseStudy.domain.model.affilation.NoAffilation;
import chapter19_SalaryCaseStudy.infla.BusinessExcepction;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class ChangeUnaffilatedTest {
	
	@Before
	public void clear(){
		PayrollDatabase.clear();
	}
	
	@Test
	public void 組合員登録削除のテスト_組合員に登録されている場合_登録を削除する() throws Exception {
		Integer empId = 1;
		Integer memberId = 10;
		new AddHourlyEmployee(empId, "name", "address",new BigDecimal(0)).execute();
		new ChangeMember(empId, memberId, new BigDecimal(1)).exec();;
		//実行
		new ChangeUnaffilated(empId).exec();
		//検証
		assertThat(PayrollDatabase.getUnionMember(memberId), is(nullValue()));
		assertThat(PayrollDatabase.getEmployee(empId).getAffilation(), is(instanceOf(NoAffilation.class)));
	}

	@Test(expected=BusinessExcepction.class)
	public void 組合員登録削除のテスト_組合員に登録されていない場合_例外を発生させる() throws Exception {
		Integer empId = 1;
		new AddHourlyEmployee(empId, "name", "address",new BigDecimal(0)).execute();
		//実行
		new ChangeUnaffilated(empId).exec();
	}
}