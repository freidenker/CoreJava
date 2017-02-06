package chapter17;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {

	public static void printKeys(Map<Integer, String> map) {
		System.out.print("Size = "+map.size()+", ");
		System.out.print("keys: ");
		System.out.println(map.keySet());
	}
	public static void test(Map<Integer, String> map){
		System.out.println(map.getClass().getSimpleName());
		map.putAll( new CountingMapDataZ(10));
		map.putAll( new CountingMapDataZ(10));
		printKeys(map);
		
		System.out.print("Values: ");
		System.out.println(map.values());
		System.out.println(map);
		System.out.println("map.containsKey(7): "+ map.containsKey(7));
		System.out.println("map.get(7): "+map.get(7));
		
		System.out.println("map.containsValue(\"F0\")"+map.containsValue("F0"));
		Integer key=map.keySet().iterator().next();
		System.out.println("First key in map: "+key);
		map.remove(key);
		printKeys(map);
		map.clear();
		System.out.println("map.isEmpty(): "+map.isEmpty());
		map.putAll(new CountingMapDataZ(10));
		map.keySet().removeAll(map.keySet());
		System.out.println("map.isEmpty(): "+map.isEmpty());		
		
		
	}
	public static void main(String[] args) {
		test(new HashMap<Integer,String>());
		test(new TreeMap<Integer,String>());
		test(new LinkedHashMap<Integer,String>());
		test(new IdentityHashMap<Integer,String>());
		test(new ConcurrentHashMap<Integer,String>());
		test(new WeakHashMap<Integer,String>());
	}

}
