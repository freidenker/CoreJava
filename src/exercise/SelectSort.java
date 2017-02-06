package exercise;

import java.util.Arrays;

public class SelectSort {

	public static void selectSort(int[] nums){
		System.out.println("select sort");
		System.out.println(Arrays.toString(nums));
		int size=nums.length;
		int temp;
		for(int i=0;i<size;i++){
			int k=i;
			for(int j=size-1;j>i;j--){
				if(nums[j]<nums[k]){
					k=j;
				}
			}
			temp=nums[i];
			nums[i]=nums[k];
			nums[k]=temp;
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public static void insertSort(int[] nums){
		System.out.println("insert sort");
		System.out.println(Arrays.toString(nums));
		int temp=0;
		for(int i=1;i<nums.length;i++){
			int j=i-1;
			temp=nums[i];
			while(j>0 && temp<nums[j]){
				nums[j+1]=nums[j];
				j--;
			}
		    nums[j+1]=temp;
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public static void main(String[] args) {
		int[] arr={2,4,3,16,6,5,9,11,21,32,27};
		//selectSort(arr);
		insertSort(arr);
	}

}
