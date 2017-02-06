package chapter17;

import java.util.LinkedHashMap;

import chapter15.Generator;

public class MapData<K,V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 1L;

	public MapData(Generator<Pair<K, V>> gen, int quantity) {
		// TODO Auto-generated constructor stub
		for(int i=0;i<quantity;i++){
			Pair<K, V> p=gen.next();
			put(p.key, p.value);
		}
	}
	
	public MapData(Generator<K> genK,Generator<V> genV,int quantity){
		for(int i=0;i<quantity;i++){
			put(genK.next(),genV.next());
		}
	}
	
	public MapData(Generator<K> genk,V value,int quantity){
		for(int i=0;i<quantity;i++){
			put(genk.next(), value);
		}
	}
	
	public MapData(Iterable<K> genk,Generator<V> genV){
		for(K key:genk){
			put(key, genV.next());
		}
	}
	
	public MapData(Iterable<K> genK,V value){
		for(K key:genK){
			put(key, value);
		}
	}
	
	public static <K,V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity){
		return new MapData<K,V>(gen, quantity);
	}
	
	public static <K,V> MapData<K, V> map(Generator<K> genk,Generator<V> genv,int quantity){
		return new MapData<>(genk, genv, quantity);
	}
	
	public static <K,V> MapData<K, V> map(Generator<K> genk,V value,int quantity){
		return new MapData<K, V>(genk, value, quantity);
	}
	
	public static <K,V> MapData<K, V> map(Iterable<K> genk,Generator<V> genv){
		return new MapData<>(genk, genv);
	}
	
	public static <K,V> MapData<K, V> map(Iterable<K> genk,V value){
		return new MapData<K, V>(genk, value);
	}

}
