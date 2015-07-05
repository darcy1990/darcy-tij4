package com.zhenai.exercise.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Exercise12 {

	public static String outputFile = "src\\tij\\io\\output.txt";

	public static void read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		List ll = new LinkedList<String>();
		while ((s = in.readLine()) != null) {
			ll.add(s);
		}
		in.close();

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				outputFile)));
		for (int i = 0; i < ll.size(); i++) {
			out.println(i + 1 + " : " + (String) ll.get(i));
		}
		out.close();
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
				new Exercise12().read(args[i]);
			}
		}
	}

}
