/*
Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.lang.Math;

class MajorityElement {

	public static void main(String[] args) {
		int[] nums = {3,2,3};
		System.out.println(majorityElement(nums));
	}

	public static int majorityElement(int[] nums) {
        if(nums.length==0)
        {
            return -1;
        }
        HashMap<Integer, Integer> store = new HashMap<>();
        float size = nums.length;
        System.out.println(size);
        float d = size/2;
        System.out.println(d);
        int numOfTimes = (int)Math.ceil(d);
        System.out.println("D- "+d+" NUM- "+numOfTimes);
        
        for(int i=0; i<nums.length; i++)
        {
            if(!store.containsKey(nums[i]))
            {
                store.put(nums[i], 1);
            }
            else
            {
                store.put(nums[i], store.get(nums[i])+1);
            }
        }
        
        Set entrySet = store.entrySet();
       	Iterator it = entrySet.iterator();
       	while(it.hasNext())
       	{
       		Map.Entry me = (Map.Entry)it.next();
       		int key = (int) me.getKey();
            int value = (int) me.getValue();
            if(value==numOfTimes)
            {
            	return key;
            }
       	}
       	//  store.forEach((key, value)-> {
       	// 	if(value.equals(numOfTimes)) {
       			
       	// 		System.out.println(key+","+value);
       	// 		return;
       	// 	}
       	// });
        return 0;
    }
}
