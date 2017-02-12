package chapter18;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

public class UpperCase {
	public static void main(String[] args) throws IOException{
		if(args.length!=1){
			System.out.println("Usage: java UpperCase file");
			return;
		}
		List<String> list=FileIntoList.read(args[0]);
		for(ListIterator<String> it=list.listIterator(list.size());it.hasPrevious();)
			System.out.println(it.previous().toUpperCase());
	}
}
