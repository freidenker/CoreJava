package chapter16;

import java.util.ArrayList;
import java.util.List;

public class ArrayofGenerics {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List<String>[] ls;
		List[] la=new List[10];
		ls=(List<String>[])la;
		ls[0]=new ArrayList<String>();
	//	ls[1]=new ArrayList<Integer>();
		
		Object[] objects=ls;
		objects[1]=new ArrayList<Integer>();
		
		List<BerylliumSphere>[] sp=(List<BerylliumSphere>[])new List[10]; 
		for(int i=0;i<sp.length;i++){
			sp[i]=new ArrayList<BerylliumSphere>();
		}
	}

}
