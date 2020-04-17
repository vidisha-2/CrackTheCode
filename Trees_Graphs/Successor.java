/*
Successor: Write an algorithm to find the "next" node(i.e., in-order successor) of a given
node in a binary search tree. You may assume that each node has a link to its parent.
"yisxjwry"
[[1,8],[1,4],[1,3],[1,6],[0,6],[1,4],[0,2],[0,1]]
*/

import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.HashSet;


class Successor {
	public static void main(String[] args) {
		int[][] arr = { {1,8},{1,4},{1,3},{1,6},{0,6},{1,4},{0,2},{0,1} };
		System.out.println(stringShift("yisxjwry",arr));
	}
	 public static String stringShift(String s, int[][] shift) {
        int amt = 0;
        for(int i=0; i<shift.length; i++) {
            
            if(shift[i][0]==0) {
            	amt -= shift[i][1];
            }
            else {
            	amt += shift[i][1];
            }
        }
        int len = s.length();
        System.out.println(len);
        System.out.println(amt);
        amt = amt%len;
        if(amt==0)
         {
        	return s;
        } else {

        	if(amt>0)
        	 {
        		String k = s.substring(len-amt);
        		//System.out.println(k);
		        String l = s.substring(0,len-amt);
		        //System.out.println(l);
		        return k+l;
        	}
        	 else {
        		amt = amt*-1;
        		String k =s.substring(len-amt, len);
        		String l = s.substring(0, len-amt);
        		return k+l;
        	}
        	

        }
        
    }
}