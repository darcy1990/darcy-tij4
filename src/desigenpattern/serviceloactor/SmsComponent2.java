package desigenpattern.serviceloactor;

/**
 * Service
 * @author zhongming.yuan
 * @date 2014-5-20
 */
public class SmsComponent2 implements IService {

	@Override
	public void send() {
		System.out.println("Hi,how are you ?");
	}

}
