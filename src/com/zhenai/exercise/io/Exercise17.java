package com.zhenai.exercise.io;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import net.mindview.util.TextFile;

public class Exercise17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise17 ex = new Exercise17();
		String text = TextFile.read("src\\tij\\io\\Exercise17.java");
		Map result = ex.count(text);
		// Pop sort ?
		System.out.println(ex.newToString(result));
	}

	public Map count(String str) {

		char[] array = str.toCharArray();
		// Comparator c = new Comparator();
		Map map = new TreeMap<Character, Integer>();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				count = (Integer) map.get(array[i]);
				count++;
				map.put(array[i], count);
			} else {
				map.put(array[i], 1);
			}
		}

		return map;
	}

	public String newToString(Map map) {
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Character, Integer> en = it.next();
			sb.append(en.getKey() + " : " + en.getValue() + "\n");
		}
		return sb.toString();
	}

}
