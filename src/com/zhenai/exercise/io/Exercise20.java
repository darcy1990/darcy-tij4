package com.zhenai.exercise.io;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import net.mindview.util.BinaryFile;
import net.mindview.util.Directory;
import net.mindview.util.Hex;
import net.mindview.util.Directory.TreeInfo;

public class Exercise20 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// TreeInfo t =
		// Directory.walk("D:\\workspace\\Prj_test\\WebContent\\WEB-INF\\classes","^.*\b.class\b$");
		// Iterator<File> it = t.iterator();
		// while (it.hasNext()) {
		// File f = it.next();
		// if (f.getName().endsWith(".class")) {
		// byte[] data = BinaryFile.read(f);
		// System.out.print(Hex.format(data).substring(0,18));
		// System.out.print("\n");
		// }
		// }

		StringBuffer a = new StringBuffer("abcds");
		a.replace(0, a.length(), "h");
		System.out.println(a);
		String b = new String("abcsd");
		b.replace('a', 'b');
		System.out.println(b.replace('a', 'b'));

	}

}
