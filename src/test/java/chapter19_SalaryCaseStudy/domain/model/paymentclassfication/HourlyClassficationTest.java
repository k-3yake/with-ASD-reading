package chapter19_SalaryCaseStudy.domain.model.paymentclassfication;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import chapter19_SalaryCaseStudy.domain.model.TimeCard;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.Hours;
import chapter19_SalaryCaseStudy.domain.value.Money;

public class HourlyClassficationTest {

	@Test
	public void 支払い金額算出のテスト_タイムカードが1日分の場合_給与はその時間とレートを掛けたもの() {
		HourlyClassfication hourlyClassfication = new HourlyClassfication(new BigDecimal(2));
		hourlyClassfication.addTimeCard(new TimeCard(new DateOnly(2000, 1, 1), new Hours(8)));
		assertThat(hourlyClassfication.calculatePay(), is(new Money(16)));
	}

	@Test
	public void 支払い金額算出のテスト_タイムカードが複数日分の場合_給与はその時間の合計とレートを掛けたもの() {
		HourlyClassfication hourlyClassfication = new HourlyClassfication(new BigDecimal(2));
		hourlyClassfication.addTimeCard(new TimeCard(new DateOnly(2000, 1, 1), new Hours(8)));
		hourlyClassfication.addTimeCard(new TimeCard(new DateOnly(2000, 1, 2), new Hours(5)));
		assertThat(hourlyClassfication.calculatePay(), is(new Money(26)));
	}

	@Test
	public void 支払い金額算出のテスト_時間外労働_8時間以上のタイムカードの場合_8時間を超えた労働時間はレートの５割増で計算すること() {
		HourlyClassfication hourlyClassfication = new HourlyClassfication(new BigDecimal(2));
		hourlyClassfication.addTimeCard(new TimeCard(new DateOnly(2000, 1, 1), new Hours(9)));
		assertThat(hourlyClassfication.calculatePay(), is(new Money(19)));
	}

	@Test
	public void 支払い金額算出のテスト_タイムカードがない場合_給与は0() {
		HourlyClassfication hourlyClassfication = new HourlyClassfication(new BigDecimal(2));
		assertThat(hourlyClassfication.calculatePay(), is(new Money(0)));
	}
}