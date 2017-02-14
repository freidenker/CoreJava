package chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

 class TextFile2 extends ArrayList<String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8865562699528345493L;

	public static String read(String fileName) throws IOException{
		StringBuilder sb=new StringBuilder();
		BufferedReader in=new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
		try{
			String s;
			while((s=in.readLine())!=null){
				sb.append(s);
				sb.append("\n");
			}
		}finally{
			in.close();
		}
		return sb.toString();
	}
	
	public static void write(String fileName,String text) throws IOException{
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName).getAbsoluteFile())));
		try {
			out.print(text);
		} finally {
			out.close();
		}
	}
	
	public TextFile2(String fileName, String splitter) throws IOException{
		super(Arrays.asList(read(fileName).split(splitter)));
		if(get(0).equals("")) remove(0);
	}
	
	public TextFile2(String fileName) throws IOException {
		this(fileName, "\n");
	}
	
	public void write(String fileName) throws IOException{
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName).getAbsoluteFile())));
		try {
			for(String item : this)
				out.println(item);
		} finally {
			out.close();
		}
	}
}
 
 public class TextFile2Test{
	 public static void main(String[] args)throws IOException{
		 String file =TextFile2.read("song.txt");
		 TextFile2.write("newtest.txt", file);
		 TextFile2 text = new TextFile2("newtest.txt");
		 text.write("newtest2.txt");
		 TreeSet<String> words = new TreeSet<String>(
				 new TextFile2("song.txt", "\\W+"));
		 System.out.println(words.headSet("a"));
	 }
 }
