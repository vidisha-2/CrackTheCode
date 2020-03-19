/*
Implement a Myqueue class which implements a queue using two stacks 
*/

import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.*;
import java.io.*;

class MyQueue {

	private Stack<Integer> s1;
	private Stack<Integer> s2;

	public MyQueue() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	/*
	public boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}

	/*public int size(){
		return s1.size() + s2.size();
	}

	public Integer peek(){
		if(isEmpty()) 
			throw new NoSuchElementException();
		if(s2.isEmpty()) moveS1toS2();
		return s2.peek();
	}*/

	public void enqueue(Integer item) {
		/*while(!s1.isEmpty()){
			s2.push(s1.pop());
		}*/
		s1.push(item);
		System.out.println(s1);
	}

	public Integer dequeue() {
		//if(isEmpty()) throw new NoSuchElementException("Queue underflow");
		if (s1.isEmpty() && s2.isEmpty()) {
			System.out.println("Underflow!!");
			System.exit(0);
		}

		// if second stack is empty, move elements from first stack to it
		if (s2.isEmpty()) {
			System.out.println("*************");
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
				System.out.println(s2);
		}

		// return the top item from the second stack
		return s2.pop();
	}

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		int[] keys = { 1, 2, 3, 4, 5 };
		
		// insert above keys
		for (int key : keys) {
			q.enqueue(key);
		}

		System.out.println(q.dequeue());	// print 1
		System.out.println(q.dequeue());	// print 2
    }
}