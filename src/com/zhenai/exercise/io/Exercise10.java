package com.zhenai.exercise.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Exercise10 {

	public static void read(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		String s;
		List ll = new LinkedList<String>();
		if (args.length > 1) {
			while ((s = in.readLine()) != null) {
				if (s.contains(args[1])) {
					ll.add(s);
				}
			}
		} else {
			while ((s = in.readLine()) != null) {
				ll.add(s);
			}
		}
		in.close();
		for (int i = ll.size() - 1; i >= 0; i--) {
			System.out.println((String) ll.get(i)); // readLine() doesn't delete
													// "\n" of every line.
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Please input file name");
		} else {
			new Exercise10().read(args);
		}
	}

}
