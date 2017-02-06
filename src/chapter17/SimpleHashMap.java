package chapter17;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K,V> extends AbstractMap<K, V>{
	static final int SIZE=997;
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K, V>>[] bukets=new LinkedList[SIZE];
	public V put(K key,V value){
		V oldValue=null;
		int index=Math.abs(key.hashCode())%SIZE;
		if(bukets[index]==null)
			bukets[index]=new LinkedList<MapEntry<K, V>>(); 
		LinkedList<MapEntry<K, V>> buket=bukets[index];
		MapEntry<K, V> pair=new MapEntry<K,V>(key,value);
		boolean found=false;
		ListIterator<MapEntry<K, V>> it=buket.listIterator();
		while(it.hasNext()){
			MapEntry<K,V> ipair=it.next();
			if(ipair.getKey().equals(key)){
				oldValue=ipair.getValue();
				it.set(pair);
				found=true;
				break;
			}
		}
		if(!found)
			bukets[index].add(pair);
		return oldValue;
	}
	public V get(Object key){
		int index=Math.abs(key.hashCode())%SIZE;
		if(bukets[index]==null) return null;
		for(MapEntry<K, V> iPair: bukets[index]){
			if(iPair.getKey().equals(key))
				return iPair.getValue();		
		}
		return null;
	}
	
	public Set<Map.Entry<K, V>> entrySet(){
		Set<Map.Entry<K, V>> set=new HashSet<Map.Entry<K,V>>();
		for(LinkedList<MapEntry<K, V>> buket: bukets){
			if (buket==null) continue;
			for(MapEntry<K, V> mpair:buket)
				set.add(mpair);
		}
		return set;
	}
	
	public static void main(String[] args) {
		SimpleHashMap<String, String> map=new SimpleHashMap<String,String>();
		map.putAll(Countries.capitals(12));
		System.out.println(map);
		System.out.println(map.get("Germany"));
		System.out.println(map.entrySet());
	}

}
