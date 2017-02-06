package chapter17;

import java.util.HashMap;
import java.util.Map;

public class HashMapLoadFactor {

	public static void testGet(Map<String , String> filledMap,int n){
		for(int tc=0;tc<100000;tc++)
			for(int i=0;i<Countries.DATA.length;i++){
				String key=Countries.DATA[i][0];
			    filledMap.get(key);
			}
	}
	
	public static void main(String args[]){
		HashMap<String, String> map1=new HashMap<String,String>();
		map1.putAll(Countries.capitals(10));
		HashMap<String, String> map2=new HashMap<String,String>(32);
		map2.putAll(map1);
		long t1=System.currentTimeMillis();
		testGet(map1, 10);
		long t2 = System.currentTimeMillis();
		System.out.println("map1 : " + (t2 - t1));
		t1 = System.currentTimeMillis();
		testGet(map2, 11);
		t2 = System.currentTimeMillis();
		System.out.println("map2 : " + (t2 - t1));
		
	}

}
