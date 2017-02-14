package chapter18;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class CountLines {

	static String file="CountLines.out";
	public static void main(String[] args) throws IOException{
		LineNumberReader in=new LineNumberReader(new FileReader("song.txt"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(file)));
		String s;
		while((s=in.readLine())!=null)
			out.println(in.getLineNumber()+": "+s);
		out.close();
		System.out.println(FileIntoList.read(file));
	}
	

}
