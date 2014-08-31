package chapter19_SalaryCaseStudy;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.AddTimeCardTransaction;
import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddHourlyEmployee;
import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddSalariedEmployee;
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeMember;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.Hours;
import chapter19_SalaryCaseStudy.domain.value.Money;
import chapter19_SalaryCaseStudy.domain.value.PayCheck;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class PaydayTest {
	@Before
	public void clear(){
		PayrollDatabase.clear();
	}
	
	@Test
	public void 給与支払い計算のテスト_月給制従業員で非組合員の場合_月給を支払う() throws Exception {
		Integer empId = 1;
		BigDecimal salary = new BigDecimal(100);
		new AddSalariedEmployee(empId, "name", "addredd", salary).execute();
		//実行
		DateOnly payDate = new DateOnly(2000, 1, 31);
		new Payday(payDate).exec(); 
		//検証
		assertThat(PayrollDatabase.getEmployee(empId).getPayMethod().getPayCheck(),is(new PayCheck(new Money(salary.doubleValue()), payDate)));
		assertThat(PayrollDatabase.getPayCheck(empId), is(new PayCheck(new Money(salary.doubleValue()), payDate)));
	}

	@Test
	public void 給与支払い計算のテスト_月給制従業員で月末でない場合_月給を支払わない() throws Exception {
		Integer empId = 1;
		BigDecimal salary = new BigDecimal(100);
		new AddSalariedEmployee(empId, "name", "addredd", salary).execute();
		//実行
		DateOnly payDate = new DateOnly(2000, 1, 30);
		new Payday(payDate).exec(); 
		//検証
		assertThat(PayrollDatabase.getEmployee(empId).getPayMethod().getPayCheck(),is(nullValue()));
		assertThat(PayrollDatabase.getPayCheck(empId), is(nullValue()));
	}

	@Test
	public void 給与支払い計算のテスト_月給制従業員で組合員の場合_月給から組合費を引いた金額を支払う() throws Exception {
		Integer empId = 1;
		BigDecimal salary = new BigDecimal(100);
		new AddSalariedEmployee(empId, "name", "addredd", salary).execute();
		BigDecimal dues = new BigDecimal(0.5);
		new ChangeMember(empId, 2, dues ).exec();
		//実行
		DateOnly payDate = new DateOnly(2000, 1, 31);
		new Payday(payDate).exec(); 
		//検証
		assertThat(PayrollDatabase.getEmployee(empId).getPayMethod().getPayCheck(),is(new PayCheck(new Money(salary.subtract(dues).doubleValue()), payDate)));
		assertThat(PayrollDatabase.getPayCheck(empId), is(new PayCheck(new Money(salary.subtract(dues).doubleValue()), payDate)));
	}
	
	@Test
	public void 給与支払い計算のテスト_時給制従業員の場合_タイムカード分の給与を支払う() throws Exception {
		Integer empId = 1;
		DateOnly payDate = new DateOnly(2014, 1, 31);
		new AddHourlyEmployee(empId, "name", "address",new BigDecimal(2)).execute();
		new AddTimeCardTransaction(empId, new DateOnly(2014, 1, 30), new Hours(3)).exec();;
		//実行
		new Payday(payDate).exec();
		//検証
		assertThat(PayrollDatabase.getEmployee(empId).getPayMethod().getPayCheck(), is(new PayCheck(new Money(6),payDate)));
	}
}