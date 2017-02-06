package chapter17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ReadOnly {
	
	static Collection<String> data=new ArrayList<String>(Countries.names(6));
	public static void main(String[] args) {
		Collection<String> c=Collections.unmodifiableCollection(new ArrayList<String>(data));
		System.out.println(c);
	//	c.add("one"); // first
		
		List<String> a=Collections.unmodifiableList(new ArrayList<String>(data));
		ListIterator<String> lit=a.listIterator();
		System.out.println(lit.next());
	//	lit.add("one");//second
		
		Set<String> ss=Collections.unmodifiableSet(new HashSet<String>(data));
		System.out.println(ss);
	//	ss.add("one");//third
		
		Set<String> ts=Collections.unmodifiableSortedSet(new TreeSet<>(data));
		Map<String, String> m=Collections.unmodifiableMap(new HashMap<String,String>(Countries.capitals(6)));
		System.out.println(m);
	//	m.put("Ralph", "Howdy");//fourth
		
		Map<String, String> tm=Collections.unmodifiableSortedMap(new TreeMap<String,String>(Countries.capitals(6)));
		}

}
