package zexamples;

import java.math.BigDecimal;

public class DivisionExample {
	public static void main(String[] args) {
		BigDecimal numerator = new BigDecimal("1");
		BigDecimal denominator = new BigDecimal("998001");

		BigDecimal result = numerator.divide(denominator);
		System.out.println("Result: " + result);
	}
}
