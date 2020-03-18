/*Palindrome: Implement a fuction to check if a list is palindrome */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Stack;
import java.util.Scanner;

class Palindrome {

	public boolean usingStack (ListNode head) {
		boolean isPalindrome = true;
		if (head==null) {
			return true;
		}

		ListNode temp = head;
		Stack<ListNode> stack = new Stack<>();
		while (temp!=null) {
			stack.push(temp);
			temp = temp.next;
		}

		temp = head;
		while (temp!=null) {
			if (temp.data!=stack.pop().data) {
				isPalindrome = false;
				break;
			}
			temp = temp.next;
		}
		return isPalindrome;
	}

	public static void main (String[] args) {
		LinkedList pList = new LinkedList(1);
		pList.add(2);
		pList.add(3);
		pList.add(2);
		pList.add(1);

		System.out.println("The Original Linked List");
		pList.print();

		System.out.println(usingStack(pList.head));

	}
}

class LinkedList {
	ListNode head;

	public LinkedList(int v) {
		head = new ListNode(v);
	}

	public void add (int val) {
		ListNode nod = new ListNode(val);
		ListNode temp = head;
		while (temp.next!=null) {
			temp = temp.next;
		}
		temp.next = nod;
	}

	public void print () {
		ListNode runner = head;
		while (runner!=null) {
			System.out.println(runner.data+ "-->");
			runner = runner.next;
			if (runner==null) {
				System.out.println("null");
			}
		}
	}
};

public class ListNode {

  int data;
  ListNode next;

  public ListNode(int v) {
    this.data = v;
    this.next = null;
  }
}