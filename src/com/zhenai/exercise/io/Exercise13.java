package com.zhenai.exercise.io;

//: io/BasicFileOutput.java
import io.BufferedInputFile;

import java.io.*;

public class Exercise13 {
	static String file = "src\\tij\\io\\BasicFileOutput.out";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(
				new StringReader(
						BufferedInputFile
								.read("D:\\workspace\\Prj_test\\src\\tij\\io\\BasicFileOutput.java")));
		LineNumberReader lnin = new LineNumberReader(in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				file)));
		// int lineCount = 1;
		String s;
		while ((s = lnin.readLine()) != null)
			out.println(lnin.getLineNumber() + ": " + s);
		out.close();
		// Show the stored file:
		System.out.println(BufferedInputFile.read(file));
	}
} /* (Execute to see output) */// :~
