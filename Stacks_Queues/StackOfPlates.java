/*
Imagine a stack of plates. if the stack gets too high, it might topple. Therefore, in real life, 
we would likely start a new stack when the previous stack exceeds some threshold. Implement a data
structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should 
create a new stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.push()
should behave identically to a single stack.

FOLLOW Up

Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
*/

import java.util.Stack;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.io.*;
import java.util.*;
import java.lang.*;

class StackOfPlates {

	private ArrayList<MyStack> numOfStacks = new ArrayList<>();
	private int capacity;

	public StackOfPlates(int capacity) {
		this.capacity = capacity;
	}

	public void push(int value) {
		MyStack laststack = this.getLastStack();

		if(laststack==null) {
			laststack = new MyStack(capacity);
			laststack.push(value);
			numOfStacks.add(laststack);
		} else {
			if(!laststack.isAtCapacity()) {
				laststack.push(value);
			} else {
				MyStack newLastStack = new MyStack(capacity);
				newLastStack.push(value);
				numOfStacks.add(newLastStack);
			}
		}		
	}

	public int pop() {
		MyStack laststack = this.getLastStack();
		int itemToPop = laststack.pop();
		if(laststack==null) {
			throw new EmptyStackException();
		}
		if(laststack.size()==0) {
			numOfStacks.remove(numOfStacks.size() - 1);
		}
		return itemToPop;
	}

	public int popAtIndex(int stackNumber) {
		MyStack stack =this.getLastStack(stackNumber);

		int v = stack.pop();
		if(stack.size() == 0) numOfStacks.remove(numOfStacks.size() -  1);
        return v;
	}

	/*public int size() {

		if(numOfStacks.isEmpty()) { return 0; }
		int totalSize = 0;

		for(Stack<T> stack : numOfStacks) {
			totalSize += stack.size();
		}
		return totalSize;
	}

	public void createNewStackAndPush(T item) {
		Stack<T> stack = new Stack<>();
		stack.push(item);
		numOfStacks.add(stack);
	}*/

	public MyStack getLastStack() {
		int size = numOfStacks.size();
		if(!numOfStacks.isEmpty()) {
			return numOfStacks.get(size - 1);
		}
		return null;
	}

	public MyStack getLastStack(int n){
        int size = numOfStacks.size();
        if(size <= 0) return null;
        else return numOfStacks.get(n - 1);
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < numOfStacks.size(); i++){
            MyStack stack = numOfStacks.get(i);
            s = " (" + stack.toString() +  s;
        }
         
        return s;
    }


	public static void main(String[] args) {
		StackOfPlates s = new StackOfPlates(3);
		s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        System.out.println("the stack is: " + s);
      	s.popAtIndex(1);
        System.out.println("pop 1st: " + s);
        s.popAtIndex(2);
        System.out.println("pop 2nd stack: " + s);
        s.popAtIndex(1);
        System.out.println("pop 1st stack: " + s);
        s.pop();
        System.out.println("pop 2nd stack: " + s);
	}

}

class MyStack {
     
    private int top = -1;   
    private int[] buffer;
    private int capacity;
     
     
    MyStack(int capacity){
        this.capacity = capacity;
        buffer = new int[capacity];
    }
     
    public void push(int v){
        buffer[++top] = v;
    }
     
    public int pop(){
         
        return buffer[top--];
    }
    // if the stack is at capacity
    public Boolean isAtCapacity(){
        return capacity == top + 1;
    }
    //return the size of the stack
    public int size(){
        return top+1;
    }
     
    public String toString(){
        String s = "";
        int index = top;
        while(index >= 0){
            s += "[" + buffer[index--] + "]"+ " -> ";
        }
        return s;
         
    }
 
}