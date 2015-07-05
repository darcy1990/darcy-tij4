package com.zhenai.exercise.io;

//: io/BasicFileOutput.java
import io.BufferedInputFile;

import java.io.*;
import java.util.Date;

public class Exercise14 {
	static String file = "src\\tij\\io\\BasicFileOutput.out";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile.read("src\\tij\\io\\test.html")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				file)));
		PrintWriter out2 = new PrintWriter(new FileWriter(file));
		BufferedReader in2 = in;
		int lineCount = 1;
		String s;
		long start = System.nanoTime();
		while ((s = in.readLine()) != null)
			out.println(lineCount++ + ": " + s);
		long end = System.nanoTime();
		;
		out.close();
		long start2 = System.nanoTime();
		while ((s = in2.readLine()) != null)
			out2.println(lineCount++ + ": " + s);
		long end2 = System.nanoTime();
		;
		out2.close();
		System.out.println(end - start);
		System.out.println(end2 - start2);
		// Show the stored file:
		// System.out.println(BufferedInputFile.read(file));
	}
} /* (Execute to see output) */// :~
