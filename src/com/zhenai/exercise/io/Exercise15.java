package com.zhenai.exercise.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise15 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream("src\\tij\\io\\Data.txt")));
		byte[] b = { 1, 2, 3, 4 };
		out.write(b, 1, 3);
		out.write(5);
		out.writeBoolean(true);
		out.writeByte(5);
		// out.writeBytes("abc123");
		out.writeChar(5);
		// out.writeChars("abc123");
		out.writeDouble(1.1);
		out.writeFloat(1.1f);
		out.writeInt(5);
		out.writeLong(12);
		out.writeShort(5);
		out.writeUTF("abc123");
		out.close();
		DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream("src\\tij\\io\\Data.txt")));
		byte[] bout = new byte[3];
		System.out.println(in.read(bout, 0, 3));
		System.out.println(in.read());
		System.out.println(in.readBoolean());
		System.out.println(in.readByte());
		// System.out.println();
		System.out.println(in.readChar());
		// System.out.println();
		System.out.println(in.readDouble());
		System.out.println(in.readFloat());
		System.out.println(in.readInt());
		System.out.println(in.readLong());
		System.out.println(in.readShort());
		System.out.println(in.readUTF());

	}

}
