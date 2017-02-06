package chapter17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class CrossInsertion {
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<String>(Countries.names(10));
		LinkedList<String> ll=new LinkedList<String>(Countries.names(12).subList(6, 10));
		
		for(Iterator<String> it=al.iterator();it.hasNext();){
			System.out.println(it.next());
		}
		System.out.println("*******************");
		for(Iterator<String> it=ll.iterator();it.hasNext();){
			System.out.println(it.next());
		}
		System.out.println("********************");
		int alindex=0;
		for(ListIterator<String> lit2=ll.listIterator();lit2.hasNext();){
			al.add(alindex,lit2.next());
			alindex +=2;
		}
		
		System.out.println("al= "+al);
		System.out.println("*********************");
		alindex=0;
		
		for(ListIterator<String> lit2=ll.listIterator(ll.size());lit2.hasPrevious();){
			al.add(alindex, lit2.previous());
			alindex+=2;
		}
		System.out.println("al= "+al);
	}

}
