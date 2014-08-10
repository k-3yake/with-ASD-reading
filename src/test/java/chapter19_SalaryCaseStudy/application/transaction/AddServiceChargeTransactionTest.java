package chapter19_SalaryCaseStudy.application.transaction;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddHourlyEmployee;
import chapter19_SalaryCaseStudy.domain.model.Employee;
import chapter19_SalaryCaseStudy.domain.model.affilation.Affilation;
import chapter19_SalaryCaseStudy.domain.model.affilation.NoAffilation;
import chapter19_SalaryCaseStudy.domain.model.affilation.UnionAffilation;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.infla.BusinessExcepction;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class AddServiceChargeTransactionTest {

	@Before
	public void clear(){
		PayrollDatabase.clear();
	}
	@Test
	public void サービス料追加のテスト_組合員がいる場合_サービス料を追加する() throws Exception {
		Integer empId = 3;
		Integer memberId = new Integer(1);
		BigDecimal serviceChargeAmount = new BigDecimal(2);
		DateOnly date = new DateOnly(2000, 1, 2);
		new AddHourlyEmployee(empId, "name", "address").execute();
		Employee employee = PayrollDatabase.getEmployee(empId);
		Affilation affilation = new UnionAffilation(new BigDecimal(1));
		employee.setAffilation(affilation);
		PayrollDatabase.addUnionMember(memberId,employee);
		//実行
		new AddServiceChargeTransaction(memberId,date,serviceChargeAmount).exec();
		//検証
		BigDecimal serviceCharge = PayrollDatabase.getUnionMember(memberId).getAffilation().getServiceCharge(date);
		assertThat(serviceCharge, is(serviceChargeAmount));
	}
	
	@Test(expected=BusinessExcepction.class)
	public void サービス料追加のテスト_組合員がいない場合_例外を発生させる() throws Exception {
		new AddServiceChargeTransaction(1,new DateOnly(2000, 1,2),new BigDecimal(1)).exec();
	}

	@Test(expected=RuntimeException.class)
	public void サービス料追加のテスト_組合に所属していない従業員が誤って登録されている場合_例外を発生させる() throws Exception {
		Integer empId = 3;
		Integer memberId = new Integer(1);
		BigDecimal serviceChargeAmount = new BigDecimal(2);
		DateOnly date = new DateOnly(2000, 1, 2);
		new AddHourlyEmployee(empId, "name", "address").execute();
		Employee employee = PayrollDatabase.getEmployee(empId);
		Affilation affilation = new NoAffilation();
		employee.setAffilation(affilation);
		PayrollDatabase.addUnionMember(memberId,employee);
		//実行
		new AddServiceChargeTransaction(memberId,date,serviceChargeAmount).exec();
	}
}