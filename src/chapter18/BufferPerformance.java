package chapter18;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BufferPerformance {
	static String file="BuferPerformance.out";
	public static void main(String[] args) throws IOException{
		List<String> list=FileIntoList.read("song.txt");
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(file)));
		int lineCount=1;
		long t1=System.currentTimeMillis();
		for(String s:list){
			for(int i=0;i<50000;i++)
				out.println(lineCount+": "+s);
			lineCount++;
		}
		long t2=System.currentTimeMillis();
		System.out.println("buffered: "+(t2-t1));
		out.close();
		
		
		out=new PrintWriter(new FileWriter(file));
		lineCount=1;
		t1=System.currentTimeMillis();
		for(String s:list){
			for(int i=0;i<50000;i++)
				out.println(lineCount+": "+s);
			lineCount++;
		}
		t2=System.currentTimeMillis();
		System.out.println("unbuffered: " + (t2 - t1));
		out.close();
	}

}
