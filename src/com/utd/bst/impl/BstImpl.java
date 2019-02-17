package com.utd.bst.impl;

import com.utd.bst.Node;

public class BstImpl {
	
	public Node root;
	public Node parent;
	
	public BstImpl(String list) {
		String[] strList = list.split(",");
		root = null;
		int val ;
		int i = 0;
		
		while(i<strList.length) {
			val = Integer.parseInt(strList[i++]);
			insertBst(root,val);
		}
	}
	
	public void insertBst(Node node,int val) {
		
		if(node == null) {
			Node nd = new Node(val);
			this.root = nd;
		}
		else if(node.val<val) {
			if(node.right == null) {insertRight(node,val);}
			else {
				insertBst(node.right,val);}
		}
		else if (node.val>val) {
			if(node.left == null) {insertLeft(node,val);}
			else {
				insertBst(node.left,val);}
		}
	}
	
	public void deleteNode(int val) {
		
		
		int replaced = Integer.MIN_VALUE;
		Node replacedNode = null;
		this.parent = null;
		Node deletedNode = searchNode(root,val);
		System.out.println("");
		System.out.println("Node to be deleted :" + val);
		
		if(deletedNode == null) {
			System.out.println("Node not found !");
		}
		else {
			
			//If the node to be deleted is a leaf node
			if(deletedNode.isLeaf()) {
				if(deletedNode == root) {
					root = null;
				}
				else if(this.parent != null && deletedNode == this.parent.left ) {
					this.parent.left = null;
				}else {
					this.parent.right = null;
				}
			}
			
			//If left child is null
			else if(deletedNode.left == null) {
				replacedNode = deletedNode.right;
				deletedNode.val = replacedNode.val;
				deletedNode.right = replacedNode.right;
				deletedNode.left = replacedNode.left;
			}
			
			//If right child is null
			else if(deletedNode.right == null) {
				replacedNode = deletedNode.left;
				deletedNode.val = replacedNode.val;
				deletedNode.left = replacedNode.left;
				deletedNode.right = replacedNode.right;
			}
			
			
			//If the node to be deleted has left child as leaf node 
			else if(deletedNode.left!= null && deletedNode.left.isLeaf()) {
				replaced = deletedNode.left.val;
				deletedNode.val = replaced;
				deletedNode.left = null;
			}
			
			//If the node to be deleted has right child as leaf node 
			else if(deletedNode.right!= null && deletedNode.right.isLeaf()) {
				replaced = deletedNode.right.val;
				deletedNode.val = replaced;
				deletedNode.right = null;
			}
			
			/* If none of the above conditions is true then find the left predecessor
			*
			* */
			else {
					
				replacedNode = findPredecessor(deletedNode.left);
				replaced = replacedNode.val;
				deletedNode.val = replaced;
				if(deletedNode.left == replacedNode) {
					deletedNode.left = replacedNode.left;
				}else 
					if(this.parent != null)
						this.parent.right = replacedNode.left;
			}
			
			
			if(replaced>Integer.MIN_VALUE)
				System.out.println("Node replaced for Deleted Node is :" + replaced);
			/*if(this.parent != null)
				System.out.println("Parent of Deleted Node is :" + this.parent.val);*/
		}
	}
	 
	Node findPredecessor(Node nd) {
		 Node node = nd;
		 if(node.right!=null) {
			 this.parent = node;
			 node = findPredecessor(node.right);
		 }
		 return node;
	 }
	
	public Node searchNode(Node nd, int val){
		
		if(nd != null) {
			if(nd.val == val) {
				return nd;
			}else if(nd.val < val && nd.right != null){
				this.parent = nd;
				return searchNode(nd.right,val);
			}else if(nd.val > val && nd.left != null){
				this.parent = nd;
				return searchNode(nd.left, val);
			}
		}
		return null;
	}
	
	public void insertRight(Node node, int val) {
		Node newNode = new Node(val);
		node.right = newNode;
	}
	
	public void insertLeft(Node node, int val) {
		Node newNode = new Node(val);
		node.left = newNode;
	}
	
	public void traverseBst() {
		System.out.println("");
		System.out.println("-----Binary Search Tree Inorder Traversal-----");
		if(root!=null) {
			inordertraverseBst(root);
		}else {
			System.out.println("Empty Binary Search Tree!");
		}
	}
	
	public void inordertraverseBst(Node node) {
		if(node.left != null) {
			inordertraverseBst(node.left);
		}
		System.out.print(" " + node.val);
		if(node.right != null) {
			inordertraverseBst(node.right);
			
		}
	}
}
