package chapter17;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

@SuppressWarnings("unchecked")
class SimpleHashMap7<K,V> extends SimpleHashMap<K, V>{
	private int count;
	private static final double loadFactor=0.75;
	private static final int initialCapacity=11;
	private int capacity=initialCapacity;
	private int threshold=(int)(capacity*loadFactor);
	{bukets=new LinkedList[capacity];}
	
	public V put(K key,V value){
		V oldValue=null;
		int index=Math.abs(key.hashCode())%capacity;
		if(bukets[index]==null)
			bukets[index]=new LinkedList<MapEntry<K, V>>();
		LinkedList<MapEntry<K, V>> bucket=bukets[index];
		MapEntry<K, V> pair=new MapEntry<K,V>(key, oldValue);
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
		if(!found){
			if(count>=threshold)
				rehash();
			if(bukets[index]==null)
				bukets[index]=new LinkedList<MapEntry<K, V>>();
			bukets[index].add(pair);
			++count;
		}
		return oldValue;
	}
	
	private boolean isPrime(int candidate){
		for(int j=2;j<candidate;j++)
			if(candidate%j==0) return false;
		return true;
	}
	private int nextPrime(int candidate){
		while(!isPrime(candidate))
			candidate++;
		return candidate;
	}
	
	
	private void rehash(){
		Iterator<Map.Entry<K, V>> it=entrySet().iterator();
		capacity = nextPrime(capacity * 2);
		System.out.println("Rehashing, new capacity =  " + capacity);
		bukets = new LinkedList[capacity];
		threshold = (int)(capacity * loadFactor);
		count = 0;
		while(it.hasNext()) {
			Map.Entry<K,V> me = it.next();
			put(me.getKey(), me.getValue());
		}
	}
	
	
}
public class SimpleHashMapRehash {

	public static void main(String[] args) {
		SimpleHashMap7<String,String> m = new SimpleHashMap7<String,String>();
		m.putAll(Countries.capitals(20));
		System.out.println(m);
	}

}
