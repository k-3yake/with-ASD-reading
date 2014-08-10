package chapter19_SalaryCaseStudy.application.transaction;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddCommisionedEmployee;
import chapter19_SalaryCaseStudy.infla.PayrollDatabase;

public class DeleteEmployeeTransactionTest {

	@Test
	public void 従業員削除のテスト() {
		//準備
		Integer empId = 1; 
		AddCommisionedEmployee add = new AddCommisionedEmployee(empId, "name", "address", new BigDecimal(0));
		add.execute();
		assertThat(PayrollDatabase.getEmployee(empId), is(notNullValue()));
		//実行
		DeleteEmployeeTransaction deleteTransaction = new DeleteEmployeeTransaction(empId);
		deleteTransaction.exec();
		//検証
		assertThat(PayrollDatabase.getEmployee(empId),is(nullValue()));
	}

}