package chapter17;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class SimpleHashMap2<K,V> extends SimpleHashMap<K, V>{
	public V put(K key,V value){
		V oldValue=null;
		int index=Math.abs(key.hashCode()) % SIZE;
		MapEntry<K, V> pair=new MapEntry<K,V>(key, value);
		if(bukets[index]==null)
			bukets[index]=new LinkedList<MapEntry<K, V>>();
		else{
			System.out.println("COllision while adding** "+pair+" **Bucket already contains:");
			Iterator<MapEntry<K, V>> it=bukets[index].iterator();
			while(it.hasNext())
				System.out.println(it.next());
		}
		LinkedList<MapEntry<K,V>> bucket = bukets[index];
		boolean found = false;
		ListIterator<MapEntry<K,V>> it = bucket.listIterator();
		while(it.hasNext()){
			MapEntry<K, V> ipair=it.next();
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
		System.out.println("begining of get() ***************************");
		int index=Math.abs(key.hashCode())%SIZE;
		int count=0;
		if(bukets[index]==null) return null;
		else{
		//	Iterator<MapEntry<K, V>> it=bukets[index].iterator();	
			LinkedList<MapEntry<K,V>> bucket = bukets[index];
			bucket.size();
			for(;count<bucket.size();count++){
								
				//System.out.println("through times: "+count);
				if(bucket.get(count).getKey().equals(key)){					
					System.out.println("through times: "+count);				   
				}
			//	System.out.println(it.next());
			}
				
		}
			
		for(MapEntry<K, V> iPair: bukets[index]){
			//count++;
			if(iPair.getKey().equals(key))
			//	System.out.println("through times: "+count);
				return iPair.getValue();		
		}
		return null;
	}
}
public class SimpleHashMapCollisons {
	public static void main(String[] args) {
		SimpleHashMap2<String,String> map=new SimpleHashMap2<String,String>();
		map.putAll(Countries.capitals(12));
		map.putAll(Countries.capitals(12));
		System.out.println(map.get("Germany"));
		System.out.println(map);
	}

}
