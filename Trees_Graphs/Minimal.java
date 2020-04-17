/*
Minimal Tree: Given a sorted(increasing order) array with unique integer elements, write
an algorithm to create a binary search tree with minimal height.
*/

import java.io.*;
import java.util.*;
import java.util.LinkedList;

class Minimal {

	public BSTNode convert(int[] arr, int start, int end) {
		if(start>end) {
			return null;
		}
		int mid = (start+end)/2;

		BSTNode root = new BSTNode(arr[mid]);
		root.left = convert(arr, start, mid-1);
		root.right = convert(arr, mid+1, end);
		return root;
	}

	public void displayTree(BSTNode root) {
		if(root!=null) {
			displayTree(root.left);
			System.out.println(" " + root.data);
			displayTree(root.right);
		}
	}

	public static void main(String[] args) {
		int [] arrA = {2,3,6,7,8,9,12,15,16,18,20};
		Minimal s = new Minimal();
		BSTNode x = s.convert(arrA, 0, arrA.length-1);
		System.out.println("Tree Display : ");
		s.displayTree(x);
	}
}

class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;

	public BSTNode(int data) {
		this.data = data;
		left  = null;
		right = null;
	}
}