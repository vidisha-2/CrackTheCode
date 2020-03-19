/*
Three in One: Describe how could you use a single array to implement three stacks.
*/

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Stack;

public class ThreeInOne {

	int[] topOfStack;
	int[] stackData;
	int[] nextIndex;
	int nextAvailable = 0;

	public ThreeInOne(int numStacks, int capacity) {
		topOfStack = new int[numStacks];
		for(int i=0; i<topOfStack.length; i++){
			topOfStack[i]=-1;
		}
	
		stackData = new int[capacity];
	
		nextIndex = new int[capacity];
		for(int i=0; i<nextIndex.length; i++) {
			nextIndex[i] = i+1;
		}
		nextIndex[nextIndex.length-1] = -1;
	}

	public void push(int stack, int value) {
		if (stack<0 || stack>=topOfStack.length) {
			throw new IndexOutOfBoundsException();
		}

		if (nextAvailable<0) return;

		int currentIndex = nextAvailable;
		nextAvailable = nextIndex[currentIndex];
		stackData[currentIndex] = value;
		nextIndex[currentIndex] = topOfStack[stack];
		topOfStack[stack] = currentIndex;
	}

	public int pop(int stack) {
		if (stack<0 || stack>=topOfStack.length || topOfStack[stack]<0) {
			throw new IndexOutOfBoundsException();
		}

		int currentIndex = topOfStack[stack];
		int value = stackData[currentIndex];
		topOfStack[stack] = nextIndex[currentIndex];
		nextIndex[currentIndex] = nextAvailable;
		nextAvailable = currentIndex;
		return value;
	}

	public static void main(String[] args) {
		int n=3, capacity=10;
		ThreeInOne stackss = new ThreeInOne(n, capacity);
		stackss.push(0,10);
		stackss.push(2,11);
		System.out.println(stackss.pop(0));
		System.out.println(stackss.pop(2));
	}

}

