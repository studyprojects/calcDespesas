package net.studyprojects.calcdespesas.jpa.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MathContextTest {

	public static void main(String[] args) {

		BigDecimal num = new BigDecimal(1.17);
		BigDecimal den = new BigDecimal(.014808);
		MathContext mc = new MathContext(9, RoundingMode.HALF_EVEN);
		BigDecimal res = num.divide(den, mc)
				.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println(res);

	}

}
