package chapter19_SalaryCaseStudy.application.transaction;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddCommisionedEmployee;
import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddSalariedEmployee;
import chapter19_SalaryCaseStudy.domain.model.SalesRecipt;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.CommistonedClassfication;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.infla.BusinessExcepction;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class AddSalesReciptTransactionTest {
	@Before
	public void clear(){
		PayrollDatabase.clear();
	}

	@Test
	public void 売り上げれシート追加のテスト_歩合制従業員の場合_売上レシートを追加する() {
		//準備
		Integer empId = 1;
		DateOnly date = new DateOnly(2000, 1, 2);
		BigDecimal amount = new BigDecimal(100);
		new AddCommisionedEmployee(empId, "name", "address", new BigDecimal(0)).execute();
		//実行
		new AddSalesReciptTransaction(empId,date,amount).exec();
		//検証
		SalesRecipt salesRecipt = ((CommistonedClassfication) PayrollDatabase.getEmployee(empId).getPaymentClassfication()).getSalesRecipt(date);
		assertThat(salesRecipt.getDate() , is(new DateOnly(2000, 1, 2)));
		assertThat(salesRecipt.getAmount(), is(amount));
	}
	
	@Test(expected=BusinessExcepction.class)
	public void 売り上げれシート追加のテスト_従業員がいない場合_例外を発生させる() {
		//実行
		new AddSalesReciptTransaction(0, new DateOnly(2000, 1, 1),new BigDecimal(0)).exec();
	}

	@Test(expected=BusinessExcepction.class)
	public void 売り上げれシート追加のテスト_従業員が歩合制ではない場合_例外を発生させる() {
		Integer empId = 1;
		new AddSalariedEmployee(empId, "name", "address", new BigDecimal(0)).execute();
		//実行
		new AddSalesReciptTransaction(empId, new DateOnly(2000, 1, 1),new BigDecimal(0)).exec();
	}
	
}
