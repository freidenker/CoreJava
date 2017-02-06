package chapter16;

import java.util.Arrays;
import java.util.Random;

public class IceCream {

	private static Random random=new Random(47);
	static final String[] FLAVORS={"Chocolate","Strawberry","Vanilla Fudge Swirl","Mint Chip",
			"Mocha Almond Fudge","Rum Raisin","Praline Cream","Mud Pie"};
	public static String[] flavorSet(int n){
		if(n>FLAVORS.length){
			throw new IllegalArgumentException("Set too big");
		}
		String[] results=new String[n];
		boolean[] picked=new boolean[FLAVORS.length];
		for(int i=0;i<n;i++){
			int t;
			do{
				t=random.nextInt(FLAVORS.length);
			}while(picked[t]);
			results[i]=FLAVORS[t];
			picked[t]=true;
		}
		return results;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<7;i++){
			System.out.println(Arrays.toString(flavorSet(3)));
		}
		
		Random rand=new Random();
		int[] arr=new int[6];
		for(int i=0;i<6;i++){
			arr[i]=rand.nextInt(i+10);
			System.err.println(arr[i]);
		}
		//int one=rand.nextInt(12);
		Random two=new Random(45);
		System.out.println("\n**********\n"+two.nextInt(34));
		System.out.println("\n**********\n"+two.nextInt(100));
		System.out.println("\n**********\n"+rand.nextInt(34));
	}

}
