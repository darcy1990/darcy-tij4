package com.zhenai.exercise.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Exercise8 {

	public static void read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		List ll = new LinkedList<String>();
		while ((s = in.readLine()) != null) {
			ll.add(s);
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
			for (int i = 0; i < args.length; i++) {
				new Exercise8().read(args[i]);
			}
		}
	}

}
