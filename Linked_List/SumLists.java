/*Sum Lists: 
Input:  (7 -> 1 -> 6) + ( 5 -> 9 -> 2)
Output:  2 -> 1 -> 9
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class SumLists {

	public static void print(Node head) {
		Node runner = head;
		while (runner!=null) {
			System.out.println(runner.data + " --> ");
			runner = runner.next;
		}
		System.out.println("null");
	}

	public static Node addLists(Node n1, Node n2) {
		Node result = null, head = null;
		int carry = 0;

		while (n1!=null || n2!=null) {
			int sum = 0;
			if (n1!=null) {
				sum += n1.data;
				n1 = n1.next;
			}
			if (n2!=null) {
				sum += n2.data;
				n2 = n2.next;
			}
			sum += carry;

			int val = sum%10;
			carry = sum/10;

			Node n3 = new Node(val);
			if (result!=null) {
				result.next = n3;
				result = result.next;
			} else {
				result = head = n3;
			}
		}
		if (carry > 0) {
			result.next = new Node(carry);
		}
		return head;
	}

	public static void main (String[] args) {
		Node n1 = new Node (7);
		n1.next = new Node (1);
		n1.next.next = new Node (6);

		Node n2 = new Node (5);
		n2.next = new Node (9);
		n2.next.next = new Node (2);

		Node result = addLists(n1, n2);
		while (result!=null) {
			System.out.print(result.data + "" );
			result = result.next;
		}
		System.out.println();
	}

}

class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
	}
};