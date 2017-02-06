package chapter17;

import java.util.HashSet;
//import java.util.LinkedHashSet;
import java.util.Set;
//import java.util.TreeSet;

public class VerifySet {

	public static void main(String[] args) {
		Set<String> set=new HashSet<String>();
		for(int i=0;i<5;i++){
			set.addAll(Countries.names(10));
			System.out.println(set);
		}
	}

}
