package chapter17;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import chapter09.Test2;


class SlowMap2<K,V> extends AbstractMap<K, V>{
	private List<K> keys=new ArrayList<K>();
	private List<V> values=new ArrayList<V>();
	
	public V put(K key,V value){
		if(key == null){
			throw new NullPointerException();
		}
		V oldValue=get(key);
		if(!keys.contains(key)){
			keys.add(key);
			values.add(value);
			
		}else{
			values.set(keys.indexOf(key), value);
		}
		return oldValue;
	}
	
	public V get(Object key){
		if(key == null)
			throw new NullPointerException();
		if(!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}
	private EntrySet entrySet=new EntrySet();
	public Set<Map.Entry<K, V>> entrySet(){
		return entrySet;
	}
	
	private class EntrySet extends AbstractSet<Map.Entry<K, V>>{
		public Iterator<Map.Entry<K, V>> iterator(){
			return new Iterator<Map.Entry<K,V>>() {
				private int index= -1;
				boolean canRemove;
				public boolean hasNext(){
					return index < keys.size() -1;
				}
				
				public Map.Entry<K, V> next(){
					canRemove=true;
					++index;
					return new MapEntry<K, V>(keys.get(index),values.get(index));
				}
				public void remove(){
					if(!canRemove)
						throw new IllegalThreadStateException();
					canRemove=false;
					keys.remove(index);
					values.remove(index--);
				}
				
			};
		}
		public boolean contains(Object o){
			if(o instanceof MapEntry){
				@SuppressWarnings("unchecked")
				MapEntry<K, V> e=(MapEntry<K,V>)o;
				K key=e.getKey();
				if(keys.contains(key))
					return e.equals(new MapEntry<K, V>(key, get(key)));
			}
			return false;
		}
		public boolean remove(Object o){
			if (contains(o)) {
				@SuppressWarnings("unchecked")
				MapEntry<K, V> e=(MapEntry<K,V>)o;
				K key=e.getKey();
				V val=e.getValue();
				keys.remove(key);
				values.remove(val);
				return true;
			}
			return false;
		}
		
		public int size(){return keys.size();}
		public void clear(){
			keys.clear();
			values.clear();
		}
	}
}
public class SlowMapTest {
	public static void printKeys(Map<Integer, String> map){
		System.out.print("size= "+map.size()+", ");
		System.out.print("Keys: ");
		System.out.println(map.keySet());
	}
	public static void test(Map<Integer, String> map){
		System.out.println(map.getClass().getSimpleName());
		map.putAll(new CountingMapDataZ(12));
		map.putAll(new CountingMapDataZ(12));
		printKeys(map);
		System.out.print("Values: ");
		System.out.println(map.values());
		System.out.println(map);
		System.out.println("map.containsKey(11): " + map.containsKey(11));
		System.out.println("map.get(11): "+map.get(11));
		System.out.println("map.containsValue(\"F0\"): "
				+ map.containsValue("F0"));
		Integer key=map.keySet().iterator().next();
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
		System.out.println("Test SlowMap");
		test(new SlowMap<Integer,String>());
		System.out.println("Test SlowMap2");
		test(new SlowMap2<Integer,String>());
	}
	

}
