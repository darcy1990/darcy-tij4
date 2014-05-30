package proxy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author zhongming.yuan
 * @date 2013-12-27
 */
public class FileOperation implements Operation{
	
	private String fileName;

	public FileOperation(String fileName) {
		this.fileName = fileName;
	}
	
	public String read()  {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in;
			in = new BufferedReader(new FileReader(fileName));
			String s;
			while ((s = in.readLine()) != null)
				sb.append(s + "\n");
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public void write(String write) {

		try {
			PrintWriter out;
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			out.println(write);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void delete() {
		File f = new File(fileName);
		if (!f.exists()) {
			System.out.println(fileName + " does not exists.");
		} else {
			f.delete();
		}
	}
	
	public void create() {
		File f = new File(fileName);
		if (f.exists()) {
			System.out.println(fileName + " exists.");
		} else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileOperation fo = new FileOperation("E:\\workspace\\Prj_test\\src\\project\\file.txt");
		fo.create();
		fo.write("Hello,world!");
		fo.read();
		
	}
	

}
