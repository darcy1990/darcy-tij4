package desigenpattern.serviceloactor;

/**
 * 
 * @author zhongming.yuan
 * @date 2014-5-20
 */
public class SmsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// method send() could be invoke many times
		SmsComponent.send();
		SmsComponent.send();
		SmsComponent.send();
	}

}
