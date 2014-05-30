package pangguo;


import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PerfectWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(perfect("dadddaadfeaewkfjaajfdl"));
	}
	
	public static int perfect(String s) {
//		char[] chars = {'a','b','c','d','e','f','g',
//				'h','i','j','k','l','m','n',
//				'o','p','q','r','s','t',
//				'u','v','w','x','y','z'};
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		int count;
		for (int i = 0; i < s.length();i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				count = map.get(c);
				count++;
				map.put(c, count);
			} else {
				map.put(c, 1);
			}
		}
		
		int perfectNumber = 26;
		int perfectTotal= 0;
		Set<Character> set = map.keySet();
		
		
		while (!map.isEmpty()) {
			char maxChar = 0;
			int maxNumber = 0;
			Iterator<Character> it = set.iterator();
			while (it.hasNext()) {
				char c = it.next();
				int number = map.get(c);
				if (number > maxNumber) {
					maxNumber = number;
					maxChar = c;
				}
			}
			perfectTotal += map.get(maxChar) * perfectNumber;
			perfectNumber--;
			map.remove(maxChar);
		}
		
		return perfectTotal;
	}

}
