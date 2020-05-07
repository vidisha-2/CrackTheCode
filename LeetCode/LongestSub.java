/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.lang.Math;

class LongestSub
{
	public static void main(String[] args)
	{
		String s = "abcabcbb";
		String s2 = "bbbbb";
		String s3 = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s3));

	}
	public  static int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
        	return -1;
        int len=0;
        int hold=0; //store length of longest substring

        HashMap<Character, Integer> cMap = new HashMap<Character, Integer>();
		        
        char[] ch = s.toCharArray();
        
        for(int j=0, i=0; j<ch.length; j++)
        {
        	if(cMap.containsKey(ch[j]))
        	{
        		i = Math.max(cMap.get(ch[i]), i);
        		//hold = i-1;
        		//cMap.put(ch[i], cMap.get(ch[i])+1);
        	}
        	len = Math.max(len, j-i+1);
        	cMap.put(ch[j], j+1);
        } 
        return len;
    }
}