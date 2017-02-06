package chapter17;

import java.util.LinkedList;

class SimpleHashMap4<K,V> extends SimpleHashMap3<K,V>{
	public int size(){
		int sz=0;
		for(LinkedList<MapEntry<K, V>> bucket : bukets){
			if(bucket != null)
				sz += bucket.size();
		}
		return sz;
	}
	public boolean isEmpty(){
		for(LinkedList<MapEntry<K, V>> buket : bukets)
			if(buket != null)
				return false;
		return true;
	}
	
	public boolean containsKey(Object key){
		for(LinkedList<MapEntry<K, V>> buket : bukets){
			if(buket == null) continue;
			for(MapEntry<K, V> mpair:buket)
				if(mpair.getKey().equals(key))
					return true;
		}
		return false;
	}
}
public class FullSimpleHashMap {
public static void main(String[] args) {
	SimpleHashMap4<String,String>
	m = new SimpleHashMap4<String,String>(),
	m2 = new SimpleHashMap4<String,String>();
	m.putAll(Countries.capitals(10));
	m2.putAll(Countries.capitals(10));
	System.out.println("m.size() = " + m.size());
	System.out.println("m.isEmpty() = " + m.isEmpty());	
	System.out.println("m.equals(m2) = " + m.equals(m2));
	System.out.println("m.containsKey(\"Germany\") = " +m.containsKey("Germany"));
	System.out.println("m.containsKey(\"MARS\") = " +m.containsKey("MARS"));
	
	System.out.println("m.keySet() = " + m.keySet());
	System.out.println("m.values() = " + m.values());
}


}
