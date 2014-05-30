package cocurrency;

import java.util.concurrent.ThreadFactory;

/**
 * Exercise9
 * @author zhongming.yuan
 * @date 2014-2-8
 */
public class SimpleThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
//	    t.setDaemon(true);
	    t.setPriority(Thread.MIN_PRIORITY);
	    return t;
	}

}
