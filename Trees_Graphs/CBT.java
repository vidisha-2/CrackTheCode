/*
Check Balanced: Implement a function to check if a binary tree is balanced. For the purpose of this question, 
a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by
more than one.
*/

import java.io.*;
import java.util.*;
import java.util.LinkedList;

class CBT {
	TreeNode root;

	public boolean isBalanced(TreeNode root, Height height) {
		/* If tree is empty then return true */
        if (root == null) { 
            height.height = 0; 
            return true; 
        } 
  
        /* Get heights of left and right sub trees */
        Height lheight = new Height(), rheight = new Height(); 
        boolean l = isBalanced(root.left, lheight); 
        boolean r = isBalanced(root.right, rheight); 
        int lh = lheight.height, rh = rheight.height; 
  
        /* Height of current node is max of heights of 
           left and right subtrees plus 1*/
        height.height = (lh > rh ? lh : rh) + 1; 
  
        /* If difference between heights of left and right 
           subtrees is more than 2 then this node is not balanced 
           so return 0 */
        if ((lh - rh >= 2) || (rh - lh >= 2)) 
            return false; 
  
        /* If this node is balanced and left and right subtrees 
           are balanced then return true */
        else
            return l && r; 
	}

	public static void main(String args[]) 
    { 
        Height height = new Height(); 
  
        /* Constructed binary tree is 
                   1 
                 /   \ 
                2      3 
              /  \    / 
            4     5  6 
            / 
           7         */
        CBT tree = new CBT(); 
        tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5); 
        tree.root.right.right = new TreeNode(6); 
        tree.root.left.left.left = new TreeNode(7); 
  
        if (tree.isBalanced(tree.root, height)) 
            System.out.println("Tree is balanced"); 
        else
            System.out.println("Tree is not balanced"); 
    } 
}

class Height {
	int height = 0;
}

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int d){
		val = d;
		left = null;
		right = null;
	}
}

/*
JAVASCRIPT SOLUTION

 Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }

  @param {TreeNode} root
 * @return {boolean}

var isBalanced = function(root) {
   var lh; //for height of left subtree 
  
        var rh; // for height of right subtree 
  
        // If tree is empty then return true 
        if (root == null) 
            return true; 
  
       //Get the height of left and right sub trees 
        lh = height(root.left); 
        rh = height(root.right); 
  
        if (Math.abs(lh - rh) <= 1
            && isBalanced(root.left) 
            && isBalanced(root.right)) 
            return true; 
  
    	// If we reach here then tree is not height-balanced 
        return false; 
    
};

var height = function(root) 
    { 
        // base case tree is empty 
        if (root == null) 
            return 0; 
  
        // If tree is not empty then height = 1 + max of left 
         height and right heights 
        return 1 + Math.max(height(root.left), height(root.right)); 
    }; 
*/