package chapter19_SalaryCaseStudy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import chapter19_SalaryCaseStudy.application.transaction.AddSalesReciptTransactionTest;
import chapter19_SalaryCaseStudy.application.transaction.AddServiceChargeTransactionTest;
import chapter19_SalaryCaseStudy.application.transaction.AddTimeCardTransactionTest;
import chapter19_SalaryCaseStudy.application.transaction.DeleteEmployeeTransactionTest;
import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddCommisionedEmployeeTest;
import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddHourlyEmployeeTest;
import chapter19_SalaryCaseStudy.application.transaction.addemployee.AddSalariedEmployeeTest;

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