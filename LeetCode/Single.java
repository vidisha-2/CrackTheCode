/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/

import java.io.*;
import java.util.*;
import java.io.HashMap;
import java.util.Arrays;
import java.util.HashSet;


class Single {

	 public static int singleNumber(int[] nums) {
        
        HashMap<Integer, Integer> p = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(p.containsKey(nums[i])) {
                int count = p.get(nums[i]);
                p.put(nums[i],++count);
            }
            else {
                p.put(nums[i],1);
            }
        }
        Set<Integer> s = p.keySet();
        Iterator<Integer> iterator = s.iterator();
        int res=0;
        while(iterator.hasNext()) {
            int key = iterator.next();
            if(p.get(key)==1) {
                res = key;
                System.out.println(key);
            }
        }
        return res;
    }
    /**
     * Given an integer array arr, count element x such that x + 1 is also in arr.
        If there're duplicates in arr, count them seperately.
     * @param arr
     * @return
     */
    public static int countElements(int[] arr) {

        Integer[] boxed = new Integer[arr.length];
        for(int i=0; i<arr.length; i++) {
            boxed[i] = Integer.valueOf(arr[i]);
        }
        List<Integer> l = Arrays.asList(boxed);
        Set<Integer> set = new HashSet<Integer>(l);
        if(set.size()<l.size()){
        	System.out.println("Contains Dup");
        }
        else
        	System.out.println("No");
      	
        int count = 0;
           
        System.out.println(set);
        for(Integer num : l ) {
        	
        	int  valueToBeCheck = num+1;
        	//System.out.println("***********"+valueToBeCheck);
        	
        	for(Integer i : set){
        		if(valueToBeCheck==i) {
        			count++;
        		}
        	}
	    }
        return count;


    /**
     * Given an array of strings, group anagrams together.

        Example:

        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
        Output:
        [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
        ]
        Note:

        All inputs will be in lowercase.
        The order of your output does not matter.
     */
        public List<List<String>> groupAnagrams(String[] strs){
    
            ArrayList<List<String>> res = new ArrayList<List<String>>();
            HashMap<String, Integer> h = new HashMap<String, Integer>();
            for (int i = 0; i < strs.length; i ++) {
                char[] tmpChar = strs[i].toCharArray();
                Arrays.sort(tmpChar);
                String tmp = new String(tmpChar);
                if (h.containsKey(tmp)) {
                    res.get(h.get(tmp)).add(strs[i]);
                    continue;
                }
                List<String> curr = new LinkedList<String>();
                curr.add(strs[i]);
                res.add(curr);
                h.put(tmp, res.size() - 1);
            }
            return res;
        }

    /** BEST TIME TO BUY AND SELL
     *  Say you have an array prices for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

        Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

        Example 1:

        Input: [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
                    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     */

        public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int buy = 0, profit=0;
        boolean x=false;
        for(int i=0; i<prices.length-1; i++) {
            int y = prices[i+1] - prices[i];
            if(y>0) {
                if(!x) {
                    buy = prices[i];
                    x = true;
                }
            }
            else if(y<0) {
                if(x) {
                    profit = profit + prices[i] - buy;
                    x = false;
                }
            }
        }
        if(x)
            profit = profit + prices[prices.length-1] - buy;
        return profit;
        }

    /**MOVE ZEROES
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

        Example:

        Input: [0,1,0,3,12]
        Output: [1,3,12,0,0]
        Note:

        You must do this in-place without making a copy of the array.
        Minimize the total number of operations.
     */

     public void moveZeroes(int[] nums) {
        int a = 0;
        for(int i:nums) {
            if(i!=0){
                nums[a++]=i;
            }
        }
            for(int i=a; i<nums.length; i++){
                nums[i]=0;
            }
        }
     
    /**
     * MAXIMUM SUBARRAY
     *  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

        Example:

        Input: [-2,1,-3,4,-1,2,1,-5,4],
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
     */

         public int maxSubArray(int[] nums) {
        int maxFar = nums[0];//stores maximun found so far
        int currMax = nums[0];//stores maximum sum at current position
        for(int i=1; i<nums.length; i++) {
            currMax += nums[i];
            currMax = Integer.max(currMax,nums[i]);
            maxFar = Integer.max(maxFar, currMax); 
        }
        return maxFar;
        }

    /**
     * Write an algorithm to determine if a number n is "happy".

        A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

        Return True if n is a happy number, and False if not.
     */

        public boolean isHappy(int n) {
        Set<Integer> uniNum = new HashSet<Integer>();
        while(uniNum.add(n)) {
            int sum = 0;
            while(n>0) {
                sum += Math.pow(n%10,2);
                n = n/10;
            }
            n=sum;
       }
        if(n==1){
            return true;
        }
        else
            return false;
     }

    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

        Note:

        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

        Example 1:

        Input: [2,2,1]
        Output: 1
     */

     public int singleNumber(int[] nums) {
        
        HashMap<Integer, Integer> p = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(p.containsKey(nums[i])) {
                int count = p.get(nums[i]);
                p.put(nums[i],++count);
            }
            else {
                p.put(nums[i],1);
            }
        }
        Set<Integer> s = p.keySet();
        Iterator<Integer> iterator = s.iterator();
        int res=0;
        while(iterator.hasNext()) {
            int key = iterator.next();
            if(p.get(key)==1) {
                res = key;
                //System.out.println(key);
            }
        }
        return res;
        }
    }


	public static void main(String[] args) {
		int [] a = { 1,5,6,2,1,6,4,3,2,5,3};
        singleNumber(a);
        int[] arr = {1,1,2};
    	int res = countElements(arr);
    	System.out.println("----->" + res);
	}
}






	

   

