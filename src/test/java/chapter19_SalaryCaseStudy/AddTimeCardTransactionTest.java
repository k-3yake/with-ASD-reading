package chapter19_SalaryCaseStudy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Test;

import chapter19_SalaryCaseStudy.domain.HourlyClassfication;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.TimeCard;
import chapter19_SalaryCaseStudy.infla.BusinessExcepction;

public class AddTimeCardTransactionTest {
	
	@After
	public void clear(){
		PayrollDatabase.clear();
	}
	
	@Test
	public void タイムカード登録のテスト_時給制従業員の場合_タイムカードを登録する() throws Exception {
		//準備
		Integer empId = 1;
		DateOnly date = new DateOnly(2000, 1, 2);
		BigDecimal hours = new BigDecimal(3.5);
		new AddHourlyEmployee(empId,"name","address").execute();
		//実行
		new AddTimeCardTransaction(empId,date,hours).exec();
		//検証
		TimeCard timeCard = ((HourlyClassfication)PayrollDatabase.getEmployee(empId).getPaymentClassfication()).getTimeCard(date);
		assertThat(timeCard.getDate(), is(new DateOnly(2000,1,2)));
		assertThat(timeCard.hours(), is(hours));
	}

	@Test(expected=BusinessExcepction.class)
	public void タイムカード登録のテスト_従業員がいない場合_エラーを発生させる(){
		//準備
		Integer empId = 1;
		DateOnly date = new DateOnly(2000, 1, 2);
		BigDecimal hours = new BigDecimal(3);
		//実行
		new AddTimeCardTransaction(empId,date,hours).exec();
	}
	
	@Test(expected=BusinessExcepction.class)
	public void タイムカード登録のテスト_時給制従業員でない場合_エラーを発生させる(){
		//準備
		Integer empId = 1;
		DateOnly date = new DateOnly(2000, 1, 2);
		BigDecimal hours = new BigDecimal(3);
		new AddCommisionedEmployee(empId, "name", "address",new BigDecimal(0)).execute();
		//実行
		new AddTimeCardTransaction(empId,date,hours).exec();
	}
}