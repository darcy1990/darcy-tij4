package generics;

import java.util.List;
import java.util.Map;

import net.mindview.util.New;

/**
 * Exercise11&12
 * @author zhongming.yuan
 * @date 2014-1-9
 */
public class NewTestA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, List<String>> sls = New.map();
		sls = New.<String, List<String>>map();
	}

}
