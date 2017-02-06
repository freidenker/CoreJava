package chapter17;

import java.util.Map;
import java.util.Properties;

public class PropertiesDemo {
	static void printKeys(Map<Object, Object> map){
		System.out.print("size = "+map.size()+", ");
		System.out.print("keys: ");
		System.out.println(map.keySet());
	}
	
	static void test(Map<Object, Object> map){
		System.out.println(map.getClass().getSimpleName());
		map.putAll(new CountingMapDataZ(15));
		map.putAll(new CountingMapDataZ(15));
		System.out.println(map);
		System.out.print("Values: ");
		System.out.println(map.values());
		System.out.println(map);
		System.out.println("map.containsKey(11): "+map.containsKey(11));
		System.out.println("map.get(11): "+map.get(11));
		System.out.println("map.containsValue(\"F0\"): "+map.containsValue("F0"));
		Object key=map.keySet().iterator().next();
		System.out.println("First key in map: "+key);
		map.remove(key);
		printKeys(map);
		map.clear();
		System.out.println("map.isEmpty(): "+map.isEmpty());
		map.putAll(new CountingMapDataZ(12));
		map.keySet().removeAll(map.keySet());
		System.out.println("map.isEmpty(): "+map.isEmpty());
	}
	
	public static void main(String[] args) {
		test(new Properties());
	}

}
