package com.utd.bst;

public class Node {
	
	public int val;
	public Node left;
	public Node right;
	
	public Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	public boolean isLeaf() {
		if(this.left == null && this.right == null) {
			return true;
		}
		return false;
	}
}
