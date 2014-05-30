package desigenpattern.serviceloactor;

/**
 * 
 * @author zhongming.yuan
 * @date 2014-5-20
 */
public class SmsTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SmsComponent2 s = new SmsComponent2();
		Locator.register(s); // register service at the beginning
		
		IService service = Locator.getSmsService(); //use service
		service.send();
	}

}
