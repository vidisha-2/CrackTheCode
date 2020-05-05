/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/

import java.io.*;
import java.util.*;
import java.util.HashMap;


class Subarray {
    public static int findComplement(int num) {
       int bit =1;
       int n = num;
       while(n!=0)
       { 
       	 num = num ^ bit;
       	 bit = bit << 1;
       	 n = n >> 1;
       }
       return num;
    }

    public static void main(String[] args)
    {
    	System.out.println(findComplement(5));
    }
}