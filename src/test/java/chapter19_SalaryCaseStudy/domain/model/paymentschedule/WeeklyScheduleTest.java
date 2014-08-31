package chapter19_SalaryCaseStudy.domain.model.paymentschedule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public class WeeklyScheduleTest {
	private WeeklySchedule weeklySchedule = new WeeklySchedule();
	
	@Test
	public void 給与日判定のテスト_金曜の場合_true() {
		assertThat(weeklySchedule.isPayDate(new DateOnly(2014, 1, 3)), is(true));
	}

	@Test
	public void 給与日判定のテスト_金曜以外_木曜の場合_false() {
		assertThat(weeklySchedule.isPayDate(new DateOnly(2014, 1, 2)), is(false));
	}

	@Test
	public void 給与日判定のテスト_金曜以外_土曜の場合_false() {
		assertThat(weeklySchedule.isPayDate(new DateOnly(2014, 1, 4)), is(false));
	}
}