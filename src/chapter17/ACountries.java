package chapter17;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ACountries {

	public static void main(String[] args) {
		TreeMap<String, String> map=new TreeMap<String,String>(Countries.capitals());
		TreeSet<String> set=new TreeSet<String>(Countries.names());
		
		String b=null;
		for(String s:map.keySet()){
			System.out.println(s);
			if(s.startsWith("B")){
				b=s;
				System.out.println("matched: "+s);
				break;
			}
		}
	//	Map<String, String> aMap=map.headMap(b,true);
	//	Set<String> aSet=set.headSet(b,true);
		Map<String, String> aMap=map.headMap(b);
		Set<String> aSet=set.headSet(b);
		
		System.out.println("amap = "+aMap);
		System.out.println("aset = "+aSet);
	}

}
