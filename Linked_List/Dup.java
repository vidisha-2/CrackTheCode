/*Remove duplicates from unsorted linked list*/

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.HashSet;
import java.util.Set;


class Dup {

	public static void print(Node head) {
		Node runner = head;
		
		while(runner!=null) {
			System.out.println(runner.data+ " --> ");
			runner = runner.next; 
		}
		System.out.println("null");
	}

	//remove duplicates//
	public static Node removeDups(Node head) {
		Node prev = null;
		Node runner = head;

		Set<Integer> set = new HashSet<>();

		while(runner!=null) {

			if(set.contains(runner.data)) {
				prev.next = runner.next;
				set.remove(runner);
			}
			else {
				set.add(runner.data); 
				prev = runner;
			}
			runner = prev.next;
		}
		return head;
	}
	
	//return kth from the end iteratively
	public static int kthbyIteration(Node head, int k) {
		if(head==null) { return 0; }
		Node firstPtr = head;
		while(k>0) {
			firstPtr = firstPtr.next;
			k--;
		}
		Node secPtr = head;
		while(firstPtr!=null) {
			firstPtr = firstPtr.next;
			secPtr = secPtr.next;
		}
		int val = secPtr.data;
		return val;
	}

	//return Kth from the end by recursively
	public static int kthbyRecursion(Node head, int k) {
		if(head==null) { return 0; }
		int val = kthbyRecursion(head.next, k);
		if(++val==k) { 
			System.out.println(head.data); 
			 }
		return val;
	}

	//delete middle node (i.e. any node, but the first and last node)
	public static Node delMiddleNode(Node mid) {
		if(mid==null || mid.next==null) { return null; }
		Node tortoise = mid;
		Node hare = mid;
		Node prevofTortoise = null;

		while(hare!=null && hare.next!=null) {
			prevofTortoise = tortoise;
			tortoise = tortoise.next;
			hare = hare.next.next;
		}
		prevofTortoise.next = tortoise.next;
		return mid;
	}

	public static void main (String[] args) {

		int[] keys = {1,2,8,3,7,0,4}; 
		Node head = null;

		for(int i=keys.length-1; i>=0; i--) {
			head = new Node(keys[i], head);
		}
		//System.out.println(kthbyIteration(head, 3));
		//System.out.println(kthbyRecursion(head, 3));
		head = delMiddleNode(head);
		//removeDups(head);
		print(head);
	}
}

class Node {
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
};
