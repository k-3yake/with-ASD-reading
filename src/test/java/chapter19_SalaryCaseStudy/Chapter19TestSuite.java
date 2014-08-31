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
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeAddressTest;
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeCommissionedTest;
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeDirectTest;
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeHoldTest;
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeHourlyTest;
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeMailTest;
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeMemberTest;
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeNameTest;
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeSalariedTest;
import chapter19_SalaryCaseStudy.application.transaction.changeemployee.ChangeUnaffilatedTest;
import chapter19_SalaryCaseStudy.domain.model.TimeCardTest;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.HourlyClassficationTest;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.BiweeklyScheduleTest;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.MonthlyScheduleTest;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.WeeklyScheduleTest;
import chapter19_SalaryCaseStudy.domain.value.HoursTest;
import chapter19_SalaryCaseStudy.domain.value.RateTest;

@RunWith(Suite.class)
@SuiteClasses({
	AddCommisionedEmployeeTest.class,
	AddHourlyEmployeeTest.class,
	AddSalariedEmployeeTest.class,
	DeleteEmployeeTransactionTest.class,
	AddTimeCardTransactionTest.class,
	AddSalesReciptTransactionTest.class,
	AddServiceChargeTransactionTest.class,
	ChangeNameTest.class,
	ChangeAddressTest.class,
	ChangeHourlyTest.class,
	ChangeCommissionedTest.class,
	ChangeSalariedTest.class,
	ChangeDirectTest.class,
	ChangeMailTest.class,
	ChangeHoldTest.class,
	ChangeMemberTest.class,
	ChangeUnaffilatedTest.class,
	PaydayTest.class,
	BiweeklyScheduleTest.class,
	MonthlyScheduleTest.class,
	WeeklyScheduleTest.class,
	HourlyClassficationTest.class,
	TimeCardTest.class,
	RateTest.class,
	HoursTest.class,
})
public class Chapter19TestSuite {

}