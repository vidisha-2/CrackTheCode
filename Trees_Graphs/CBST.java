/*
Validate BST: Implement a function to check if a binary tree is a binary search tree.
*/
import java.io.*;
import java.util.*;
import java.util.LinkedList;
  
public class BinaryTree 
{ 
    // Root of the Binary Tree 
    Node root; 
  
    // To keep tract of previous node in Inorder Traversal 
    Node prev; 
  
    boolean isBST()  { 
        prev = null; 
        return isBST(root); 
    } 
  
    /* Returns true if given search tree is binary 
       search tree (efficient version) */
    boolean isBST(Node node) 
    { 
        // traverse the tree in inorder fashion and 
        // keep a track of previous node 
        if (node != null) 
        { 
            if (!isBST(node.left)) 
                return false; 
  
            // allows only distinct values node 
            if (prev != null && node.data <= prev.data ) 
                return false; 
            prev = node; 
            return isBST(node.right); 
        } 
        return true; 
    } 
  
    /* Driver program to test above functions */
    public static void main(String args[]) 
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3); 
  
        if (tree.isBST()) 
            System.out.println("IS BST"); 
        else
            System.out.println("Not a BST"); 
    } 
} 

class Node 
{ 
    int data; 
    Node left, right; 
  
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 


/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 

var isValidBST = function(root) {
    
   return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
};

var isValidBST = function(root, minValue, maxValue) {
	if (root == null)
		return true;
	if (root.val <= minValue || root.val >= maxValue)
		return false;
	return isValidBST(root.left, minValue, root.val) && 
		isValidBST(root.right, root.val, maxValue);
};

*/
