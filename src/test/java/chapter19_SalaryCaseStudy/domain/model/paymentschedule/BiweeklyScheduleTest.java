package chapter19_SalaryCaseStudy.domain.model.paymentschedule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;

public class BiweeklyScheduleTest {
	private BiweeklySchedule biweeklySchedule = new BiweeklySchedule();

	@Test
	public void 給与日判定のテスト_年で一回目の金曜日の場合_true() {
		assertThat(biweeklySchedule.isPayDate(new DateOnly(2014, 1, 3)), is(true));
	}

	@Test
	public void 給与日判定のテスト_年で2回目の金曜日の場合_false() {
		assertThat(biweeklySchedule.isPayDate(new DateOnly(2014, 1, 10)), is(false));
	}

	@Test
	public void 給与日判定のテスト_年で3回目の金曜日の場合_true() {
		assertThat(biweeklySchedule.isPayDate(new DateOnly(2014, 1, 17)), is(true));
	}
}