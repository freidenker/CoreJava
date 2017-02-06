package chapter17;

import java.util.TreeSet;

import chapter16.RandomGenerator;

public class RandTreeSet {

	public static void main(String[] args) {
		TreeSet<String> ts=new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		ts.addAll(CollectionData.list(new RandomGenerator.String(), 10));
		System.out.println("ts = "+ts);
	}

}
