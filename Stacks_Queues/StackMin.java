/*
How would you design a stack which, in addition to push and pop, has a function min
which returns the minimun element? Push, pop and min should all operate in O(1) time.
*/

import java.util.Stack;
import java.io.*;
import java.lang.*;
import java.util.*;

public class StackMin {
	
	private Stack<Integer> s = new Stack<>();
	private int min;

	public void push(int x) {

		if(s.empty()) {
			s.push(x);
			min = x;
		}
		else if(x>min) {
			s.push(x);
		}
		else {
			s.push(2*x-min);
			min = x;
		}
	}

	public void pop() {

		if(s.empty()) {
			System.out.println("Stack underflow");
		}
		int top = s.peek();
		if(top<min)
			min = 2*min-top;
		s.pop();
	}

	public int min() {
		return min;
	}

	public static void main (String[] args) {
		StackMin s = new StackMin();

		s.push(6);
		s.push(7);
		s.push(5);
		s.push(3);
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
	}
}


