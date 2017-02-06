package chapter17;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;


class MapEntrySlowMap1<K,V> extends AbstractMap<K, V>{
	protected List<MapEntry<K, V>> entries=new ArrayList<MapEntry<K,V>>();
	protected MapEntry<K, V> getEntry(Object key){
		for(MapEntry<K, V> entry:entries)
			if(entry.getKey().equals(key))
				return entry;
		return null;
	}
	public V put(K key,V value){
		if(key == null)
			throw new NullPointerException();
		MapEntry<K, V> oldEntry=getEntry(key);
		V oldValue=null;
		if(oldEntry == null)
			entries.add(new MapEntry<K,V>(key,value));
		else{
			oldValue=oldEntry.getValue();
			oldEntry.setValue(value);
		}
		return oldValue;
	}
	public V get(Object key){
		if(key == null)
			throw new NullPointerException();
		MapEntry<K,V> entry = getEntry(key);
		return entry == null ? null : entry.getValue();
	}
	
	private EntrySet entrySet = new EntrySet();
	@Override public Set<Map.Entry<K,V>> entrySet() {
	return entrySet;
	}
	
	private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
		public Iterator<Map.Entry<K,V>> iterator() {
			return new Iterator<Map.Entry<K,V>>() {
				private int index=-1;
				boolean canRemove;
				public boolean hasNext(){
					return index<entries.size()-1;
				}
				public Map.Entry<K, V> next(){
					canRemove=true;
					++index;
					return entries.get(index);
				}
				public void remove(){
					if(!canRemove)
						throw new IllegalStateException();
					canRemove=false;
					entries.remove(index--);
				}
			};
		} 
		public boolean contains(Object o){
			if(o instanceof MapEntry){
				MapEntry<K, V> e=(MapEntry<K,V>)o;
				return e.equals(getEntry(e.getKey()));
			}
			return false;
		}
		public boolean remove(Object o){
			if(contains(o)){
				entries.remove((MapEntry<K, V>)o);
				return true;
			}
			return false;
		}
		public int size(){
			return entries.size();
		}
		public void clear(){
			entries.clear();
		}
	}
	
}
class MapEntryComp<K,V> implements Comparator<MapEntry<K, V>>{
	public int compare(MapEntry<K, V> o1,MapEntry<K, V> o2){
		Comparable<K> c1=(Comparable<K>)o1.getKey();
		return c1.compareTo(o2.getKey());
	}
}

class MapEntrySlowMap2<K,V> extends MapEntrySlowMap1<K,V>{
	final MapEntryComp<K,V> comp = new MapEntryComp<K,V>();
	protected MapEntry<K, V> getEntry(Object key){
		MapEntry<K, V> searchEntry=new MapEntry<K,V>((K)key,null);
		int index=Collections.binarySearch(entries, searchEntry,comp);
		if(index>=0)
			return entries.get(index);
		return null;
	}
	public V put(K key, V value) {
		if(key==null)
			throw new NullPointerException();
		MapEntry<K,V> oldEntry = getEntry(key);
		V oldValue=null;
		if(oldEntry==null){
			entries.add(new MapEntry<K,V>(key, value));
			Collections.sort(entries, comp);
		}else{
			oldValue = oldEntry.getValue();
			oldEntry.setValue(value);
		}
		return oldValue;
	}
}

public class MapEntrySlowMapTest {

	public static void main(String[] args) {
		System.out.println("Testing MapEntrySlowMap1");
		SlowMapTest.test(new MapEntrySlowMap1<Integer,String>());
		
		System.out.println("Testing MapEntrySlowMap2");
		SlowMapTest.test(new MapEntrySlowMap2<Integer,String>());
		
		if(args.length > 0)Tester.defaultParams = TestParam.array(args);
		Tester.run(new TreeMap<Integer,Integer>(),MapPerformance.tests);
		Tester.run(new HashMap<Integer,Integer>(),MapPerformance.tests);
		Tester.run(new LinkedHashMap<Integer,Integer>(),MapPerformance.tests);
		
		Tester.run(new IdentityHashMap<Integer,Integer>(),MapPerformance.tests);
		Tester.run(new WeakHashMap<Integer,Integer>(),MapPerformance.tests);
		Tester.run(new Hashtable<Integer,Integer>(),MapPerformance.tests);
		Tester.run(new SlowMap2<Integer,Integer>(),MapPerformance.tests);
		Tester.run(new MapEntrySlowMap1<Integer,Integer>(),MapPerformance.tests);
		Tester.run(new MapEntrySlowMap2<Integer,Integer>(),MapPerformance.tests);
	}

}
