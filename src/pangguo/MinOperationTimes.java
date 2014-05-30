package pangguo;

import java.io.ObjectInputStream.GetField;

public class MinOperationTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abcdedddfvvvghkkkmggg";
		String s2 = "vbcdakdmvhdefdkgvgggk";
		int time = getMinOperationTimes(s1, s2);
		System.out.println(time);
	}
	
	static int getMinOperationTimes(String s1, String s2) {
		int time = 0;
		for(int i = s2.length() - 1; i >= 0 ; i--) {
			char c = s2.charAt(i);
			int index = s1.indexOf(c);
			time += s1.length() - 1 - index;
			// move the chars after the index to the front
			StringBuffer sb = new StringBuffer(s1.substring(index + 1, s1.length()));
			sb.append(s1.substring(0, index));
			s1 = sb.toString();
		}
		return time;
	}

}
/*
eabdc cabde
ceabd ecabd
ceab  ecab  
bcea  beca  aceb
abce  baec  bace
abc   cbae  bac
cab   cba   cba
bca   bca   bca*/
