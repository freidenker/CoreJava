package chapter16;

import java.util.Arrays;

public class ReturningArr {

	static BerylliumSphere[] createArray(int size){
		BerylliumSphere[] a=new BerylliumSphere[size];
		for(int i=0;i<size;i++){
			a[i]=new BerylliumSphere();
		}
		return a;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(createArray(5)));
	}

}
