package chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListSortSearch {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>(Utilities.list);
		list.addAll(list);
		System.out.println(list);
		
		Collections.shuffle(list,new Random(47));
		System.out.println("shuffled: "+list);
		
		ListIterator<String> it=list.listIterator(10);
		while(it.hasNext()){
			it.next();
			it.remove();
		}
		System.out.println("Timmed: "+list);
		Collections.sort(list);
		System.out.println("sorted: "+list);
		
		String key=list.get(7);
		int index=Collections.binarySearch(list, key);
		System.out.println("Location of "+key+" is "+index+", list.get("+index+") = "+list.get(index));
		Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
		System.out.println("case-insensitive sorted: "+list);
		key=list.get(7);
		index=Collections.binarySearch(list, key,String.CASE_INSENSITIVE_ORDER);
		System.out.println("Location of "+key+" is "+index+", list.get("+index+") = "+list.get(index));
	}

}
