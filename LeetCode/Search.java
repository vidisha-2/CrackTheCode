

import java.io.*;
import java.util.*;


class Search{

	public static void main(String[] args) {
		int[] pound = {4,5,6,7,0,1,2};
		int find = 0;
		int result = search(pound, find);
		System.out.println(result);
	}

	public static int search(int[] nums, int target) {
        if(nums.length==0) {
            return -1;
        }
        int left = 0;
    int right= nums.length-1;
 
    while(left<=right){
        int mid = left + (right-left)/2;
        if(target==nums[mid])
            return mid;
 
        if(nums[left]<=nums[mid]){
            if(nums[left]<=target&& target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }else{
            if(nums[mid]<target&& target<=nums[right]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }    
    }
 
    return -1;
    } 
    
   
}