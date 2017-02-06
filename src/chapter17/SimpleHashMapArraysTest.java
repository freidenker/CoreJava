package chapter17;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

class SimpleHashMap6<K,V> extends AbstractMap<K, V>{
	static final int SIZE=997;
	@SuppressWarnings("unchecked")
	ArrayList<MapEntry<K, V>>[] bukets=new ArrayList[SIZE];
	public V put(K key,V value){
		V oldValue=null;
		int index=Math.abs(key.hashCode())%SIZE;
		if(bukets[index]==null)
			bukets[index]=new ArrayList<MapEntry<K, V>>();
		ArrayList<MapEntry<K, V>> bucket=bukets[index];
		MapEntry<K, V> pair=new MapEntry<K,V>(key,value);
		boolean found=false;
		ListIterator<MapEntry<K, V>> it=bucket.listIterator();
		while(it.hasNext()){
			MapEntry<K, V> iPair=it.next();
			if(iPair.getKey().equals(key)){
				oldValue=iPair.getValue();
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
		if(bukets[index] == null) return null;
		for(MapEntry<K, V> iPair:bukets[index])
			if(iPair.getKey().equals(key))
				return iPair.getValue();
		return null;
	}
	
	public Set<Map.Entry<K, V>> entrySet(){
		Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
		for(ArrayList<MapEntry<K, V>> bucket:bukets){
			if(bucket==null) continue;
			for(MapEntry<K, V> mpair:bucket)
				set.add(mpair);
		}
		return set;
	}
	@SuppressWarnings("unchecked")
	public void clear(){
		bukets=new ArrayList[SIZE];
	}
	public V remove(Object key){
		int index=Math.abs(key.hashCode())% SIZE;
		if(bukets[index]==null) return null;
		Iterator<MapEntry<K, V>> it=bukets[index].iterator();
		while(it.hasNext()){
			MapEntry<K, V> iPair=it.next();
			if(iPair.getKey().equals(key)){
				V value=iPair.getValue();
				it.remove();
				return value;
			}
		}
		return null;
	}
	public int size(){
		int sz=0;
		for(ArrayList<MapEntry<K, V>> bucket:bukets)
			if(bucket!=null)
				sz+=bucket.size();
		return sz;
	}
	public boolean isEmpty(){
		for(ArrayList<MapEntry<K, V>> bucket:bukets)
			if(bucket!=null)
				return false;
		return true;
	}
	public boolean containsKey(Object key){
		for(ArrayList<MapEntry<K, V>> bucket:bukets){
			if(bucket == null ) continue;
			for(MapEntry<K, V> mPair:bucket)
				if(mPair.getKey().equals(key))
					return true;
		}
		return false;
	}
}
public class SimpleHashMapArraysTest {
	public static void main(String[] args) {
		if(args.length>0)
			Tester.defaultParams=TestParam.array(args);
		Tester.run(new SimpleHashMap4<Integer,Integer>(),MapPerformance.tests);
		Tester.run(new SimpleHashMap5<Integer,Integer>(),MapPerformance.tests);
		Tester.run(new SimpleHashMap6<Integer,Integer>(),MapPerformance.tests);
	}


}
