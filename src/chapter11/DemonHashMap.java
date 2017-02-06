package chapter11;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DemonHashMap {

	public DemonHashMap() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		Random rnd=new Random(47);
		Map<Integer,Integer> m=new HashMap<Integer,Integer>();
		for(int i=0;i<10000;i++){
			int r=rnd.nextInt(20);
			Integer freq=m.get(r);
			m.put(r, freq ==null ?1:freq+1);
			
		}
		System.out.println(m);
	}
}
