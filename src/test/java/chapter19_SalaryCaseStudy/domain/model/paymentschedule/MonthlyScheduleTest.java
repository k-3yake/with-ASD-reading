package chapter19_SalaryCaseStudy.domain.model.paymentschedule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public class MonthlyScheduleTest {
	private MonthlySchedule monthlySchedule = new MonthlySchedule(); 

	@Test
	public void 給与日判定のテスト_月末の場合_true() {
		DateOnly payDate = new DateOnly(2014, 1, 31);
		assertThat(monthlySchedule.isPayDate(payDate), is(true));
	}
	
	@Test
	public void 給与日判定のテスト_月末以外_月初_の場合__false() {
		DateOnly payDate = new DateOnly(2014, 1, 1);
		assertThat(monthlySchedule.isPayDate(payDate), is(false));
	}

	@Test
	public void 給与日判定のテスト_月末以外_月末前日_の場合__false() {
		DateOnly payDate = new DateOnly(2014, 1, 30);
		assertThat(monthlySchedule.isPayDate(payDate), is(false));
	}
}