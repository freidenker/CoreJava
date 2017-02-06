package exercise;

import java.util.Arrays;

public class BubbleSort {

	public static void bubblesort(int[] nums){
		int temp;
		int size=nums.length;
		System.out.println(Arrays.toString(nums));
		for(int i=0;i<size-1;i++){
			for(int j=0;j<size-1-i;j++){
				if(nums[j]<nums[j+1]){
					temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
				}
			}
		
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public static void main(String[] args) {
		int[] arr={2,5,4,7,34,21,12,78,45,23};
		bubblesort(arr);
	}

}
