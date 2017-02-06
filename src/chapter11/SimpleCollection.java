package chapter11;

import java.util.HashSet;
import java.util.Set;

public class SimpleCollection {

	public SimpleCollection() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		Set<Integer> se=new HashSet<Integer>();
		for(int i=0;i<10;i++){
			se.add(i);
		}
		se.add(10);
		for(Integer i : se){
			System.out.println("Nomb "+i);
		}
	}

}
