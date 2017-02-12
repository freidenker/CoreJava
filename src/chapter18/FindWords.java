package chapter18;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class FindWords {
	public static void main(String[] args) throws IOException{
		if(args.length<2){
			System.err.println("Usage: java FindWords file words");
			return;
		}
		Set<String> words=new HashSet<String>();
		for(int i=1;i<args.length;i++)
			words.add(args[i]);
		List<String> list=FileIntoList.read(args[0]);
		for(ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();){
			String candidate=it.previous();
			for(String word:words)
				if(candidate.indexOf(word)!= -1){
					System.out.println(candidate);
					break;
				}
		}
	}
}
