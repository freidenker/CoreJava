package chapter17;

import java.util.Iterator;
import java.util.LinkedList;

class SimpleHashMap3<K,V> extends SimpleHashMap<K, V>{
	@SuppressWarnings("unchecked")
	public void clear(){
		bukets=new LinkedList[SIZE];
	}
	public V remove(Object key){
		int index=Math.abs(key.hashCode()) % SIZE;
		if(bukets[index]==null) return null;
		Iterator<MapEntry<K, V>> it=bukets[index].iterator();
		while(it.hasNext()){
			MapEntry<K, V> ipair=it.next();
			if(ipair.getKey().equals(key)){
				V value=ipair.getValue();
				it.remove();
				return value;
			}
		}
		return null;
	}
}
public class SimpleHashMapClearRemove {
	public static void main(String[] args) {
		SimpleHashMap3<String,String> map=new SimpleHashMap3<String,String>();
		map.putAll(Countries.capitals(12));
		System.out.println(map);
		System.out.println("map.get(\"Germany\") = " +map.get("Germany"));
		map.remove("Germany");
		System.out.println("after remove: "+map.get("Germany"));
		map.clear();
		System.out.println("After Clearing: "+map);
	}

}
