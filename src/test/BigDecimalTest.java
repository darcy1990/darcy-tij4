package test;
import java.math.BigDecimal;

/**
 * Test BigDecimal
 * @author zhongming.yuan
 * @date 2014-5-26
 */
public class BigDecimalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(BigDecimal.valueOf(10).divide(BigDecimal.valueOf(3).setScale(2, BigDecimal.ROUND_UP)));
		System.out.println(BigDecimal.valueOf(10).divide(BigDecimal.valueOf(3), 2, BigDecimal.ROUND_UP));
	}

}
