package chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class FileIntoList {
	public static List<String> read(String filename) throws IOException {
		BufferedReader in=new BufferedReader(new FileReader(filename));
		String s;
		List<String> list=new LinkedList<String>();
		while((s=in.readLine())!=null){
			list.add(s);
			
		}
		in.close();
		return list;
	}
	
	public static void main(String[] args) throws IOException{
		List<String> list=read("test3.txt");
		for(ListIterator<String> it=list.listIterator(list.size());it.hasPrevious();)
			System.out.println(it.previous());
	}
}
