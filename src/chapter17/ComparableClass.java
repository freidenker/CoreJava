package chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import chapter15.Generator;
import chapter16.Generated;
import chapter16.RandomGenerator;

class TwoString implements Comparable<TwoString>{
	String s1,s2;
	public TwoString(String s1i,String s2i){
		s1=s1i;
		s2=s2i;
	}
	public String toString(){
		return "[s1 = "+s1+", s2 = "+s2+"]";
	}
	public int compareTo(TwoString rv){
		String rvi=rv.s1;
		return s1.compareTo(rvi);
	}
	private static RandomGenerator.String gen = new RandomGenerator.String();
	public static Generator<TwoString> generator() {
		return new Generator<TwoString>() {
			public TwoString next(){
				return new TwoString(gen.next(),gen.next());
			}
		};
	}
}

class CompareSecond implements Comparator<TwoString> {
	public int compare(TwoString sc1, TwoString sc2) {
		return sc1.s2.compareTo(sc2.s2);
		}
}
public class ComparableClass {
	public static void main(String[] args) {
		TwoString[] array = new TwoString[10];
		Generated.array(array, TwoString.generator());
		System.out.println("before sorting, array = " +Arrays.asList(array));
		Arrays.sort(array);
		System.out.println("\nafter sorting, array = " +Arrays.asList(array));
		Arrays.sort(array, new CompareSecond());
		System.out.println("\nafter sorting with CompareSecond, array = " +Arrays.asList(array));
		
		ArrayList<TwoString> list = new ArrayList<TwoString>(CollectionData.list(TwoString.generator(), 10));
		TwoString zeroth = list.get(0);
		System.out.println("\nbefore sorting, list = " + list);
		Collections.sort(list);
		System.out.println("\nafter sorting, list = " + list);
		Comparator<TwoString> comp = new CompareSecond();
		Collections.sort(list, comp);
		System.out.println("\nafter sorting with CompareSecond, list = "+ list);
		int index = Collections.binarySearch(list, zeroth, comp);
		System.out.println("\nFormer zeroth element " +zeroth + " now located at " + index);
	}

}
