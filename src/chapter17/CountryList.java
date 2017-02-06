package chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CountryList {

	private static Random rnd=new Random();
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>(Countries.names(8));
		Collections.sort(list);
		System.out.println("sorted: "+list);
		
		for(int i=0;i<5;i++){
			Collections.shuffle(list, rnd);
			System.out.println("shuffled "+i+": "+list);
		}
	}

}
