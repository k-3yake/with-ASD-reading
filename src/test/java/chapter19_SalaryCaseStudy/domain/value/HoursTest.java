package chapter19_SalaryCaseStudy.domain.value;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class HoursTest {
	
	@Test
	public void Argより大いか判定のテスト_大い場合_true() {
		assertThat(new Hours(10.1).moreThan(new Hours(10)), is(true));
	}

	@Test
	public void Argより大いか判定のテスト_同じ場合_false() {
		assertThat(new Hours(10.0).moreThan(new Hours(10)), is(false));
	}

	@Test
	public void Argより大いか判定のテスト_小さい場合_false() {
		assertThat(new Hours(9.9).moreThan(new Hours(10)), is(false));
	}
	
	@Test
	public void 除算のテスト() throws Exception {
		assertThat(new Hours(3.5).substract(new Hours(1.2)),is(new Hours(2.3)));
	}

	@Test
	public void 除算のテスト_マイナスの場合() throws Exception {
		assertThat(new Hours(1.1).substract(new Hours(3.2)),is(new Hours(-2.1)));
	}
	
	@Test
	public void 等価性のテスト_等しい場合_true() throws Exception {
		assertThat(new Hours(1.2).equals(new Hours(1.2)),is(true));
	}

	@Test
	public void 等価性のテスト_等しくない場合_false() throws Exception {
		assertThat(new Hours(1.2).equals(new Hours(2.2)),is(false));
	}
}