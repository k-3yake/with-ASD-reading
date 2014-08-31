package chapter19_SalaryCaseStudy.application.transaction.changeemployee;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddHourlyEmployee;
import chapter19_SalaryCaseStudy.domain.model.affilation.UnionAffilation;
import chapter19_SalaryCaseStudy.domain.value.Money;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class ChangeMemberTest {
	@Before
	public void clear(){
		PayrollDatabase.clear();
	}

	@Test
	public void メンバー情報変更のテスト_未加入の場合_メンバーに加入する() throws Exception {
		Integer empId = 1;
		new AddHourlyEmployee(empId, "name", "address",new BigDecimal(0)).execute();
		Integer memberId = 100;
		int dues = 10;
		new ChangeMember(empId,memberId,new BigDecimal(dues)).exec();
		assertThat(PayrollDatabase.getUnionMember(memberId), is(PayrollDatabase.getEmployee(empId)));
		assertThat(((UnionAffilation)PayrollDatabase.getUnionMember(memberId).getAffilation()).getDues(), is(new Money(dues)));
	}
}