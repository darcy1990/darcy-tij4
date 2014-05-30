package desigenpattern.serviceloactor;

/**
 * Locator
 * @author zhongming.yuan
 * @date 2014-5-20
 */
public class Locator {

	private static IService service; // could be a list of service
	
	public static void register(IService s) {
		service = s;
	}
	
	public static IService getSmsService() {
		return service;
	}
	
}
