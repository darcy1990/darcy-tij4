package generics;

import java.util.LinkedList;

import net.mindview.util.New;

/**
 * Exercise11&12
 * @author zhongming.yuan
 * @date 2014-1-9
 */
public class NewTestB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> lls = New.lList();
		lls = New.<String> lList();
	}

}
