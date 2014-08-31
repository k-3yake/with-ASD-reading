package chapter19_SalaryCaseStudy.domain.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.Hours;

public class TimeCardTest {

	@Test
	public void 残業時間取得のテスト_8時間以内の場合_残業時間はない() {
		assertThat(new TimeCard(new DateOnly(2000, 1, 1), new Hours(8)).overTimes(), is(new Hours(0)));
	}

	@Test
	public void 残業時間取得のテスト_8時間以上の場合_８時間を超えた分が残業になる() {
		TimeCard timeCard = new TimeCard(new DateOnly(2000, 1, 1), new Hours(8.1));
		assertThat(timeCard.overTimes(), is(new Hours(0.1)));
		assertThat(timeCard.normalTimes(), is(new Hours(8)));
	}
}