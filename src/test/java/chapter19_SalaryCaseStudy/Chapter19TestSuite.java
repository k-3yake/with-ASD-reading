package chapter19_SalaryCaseStudy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AddCommisionedEmployeeTest.class,
	AddHourlyEmployeeTest.class,
	AddSalariedEmployeeTest.class,
	DeleteEmployeeTransactionTest.class,
	AddTimeCardTransactionTest.class,
	AddSalesReciptTransactionTest.class,
	AddServiceChargeTransactionTest.class,
	
})
public class Chapter19TestSuite {

}