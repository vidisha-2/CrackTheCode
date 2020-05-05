/*
  First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/
import java.io.*;
import java.util.*;
import java.util.HashMap;


class NonRepeating {
	public static void main(String[] args)
	{
		String pin = "nana";
		System.out.println(firstUniqChar(pin));
	}
	public static int firstUniqChar(String s) {
        if(s.length()==0)
        {
            return -1;
        }
        HashMap<Character, Integer> cMap = new HashMap<Character, Integer>();
        char[] ch = s.toCharArray();
        int index=0;
        
        for(int i=0; i<ch.length; i++)
        { 	
        	if(cMap.containsKey(ch[i]))
        	{
        		cMap.put(ch[i], cMap.get(ch[i])+1);
        	}
        	else {
        		
        		cMap.put(ch[i], 1);
        	}
        }
       
        for(int i=0; i<ch.length; i++)
        {
        	if(cMap.get(ch[i])==1)
        	{
        		index = i;
        		break;
        	}
        	else if(cMap.get(ch[i])!=1)
        	{
        		index = -1;
           	}
       	}
       	 return index;
    }
}