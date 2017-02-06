package exercise;

//import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	static int[] twoSum(int[] nums, int target){
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[j] == target-nums[i]){
					return new int[]{i,j};
				    
				}
			}
		}
		throw new IllegalArgumentException("no solution");
	}
	
	public static int[] twoSum2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	public static Map<Integer, Integer> twoSum3(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    Map<Integer, Integer> result = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	          //  return new int[] { i, map.get(complement) };
	        	result.put(i, map.get(complement));
	        }
	    }
   //     System.out.println(result);
        return result;
	//    throw new IllegalArgumentException("No two sum solution");
	}
	
	
	public static void main(String[] args) {
	//	int target=10;
		int target=8;
	//	int[] arr={1,2,3,4,5,6,7,8,9,10};
		int[] arr={7,4,6,9,1,4,10,23,16};
	//	System.out.println(arr.length/2);
		twoSum(arr,target);
	//	System.out.println(Arrays.toString(twoSum(arr,target)));
		System.out.println(twoSum3(arr,target));
		System.out.println("********************\n");
		
	}

}
