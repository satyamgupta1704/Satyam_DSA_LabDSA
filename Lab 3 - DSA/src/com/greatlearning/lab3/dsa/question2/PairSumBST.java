package com.greatlearning.lab3.dsa.question2;

// Java program to find a pair with given sum using hashing
import java.util.*;

public class PairSumBST {

	// Define static class node for creation of BST
	static class Node {
		int data;
		Node left, right;
	};

	// Creation and Initialization of NewNode in BST
	static Node NewNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	/*
	 * Define insert method of Node type which takes root and key as params, and add
	 * nodes to the BST
	 */
	static Node insert(Node root, int key) {
		if (root == null)
			return NewNode(key);
		if (key < root.data)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}

	/*
	 * Define findpairUtil method which acts as a utility function to return
	 * appropriate pair based on provided sum value.
	 */
	static boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;

		if (findpairUtil(root.left, sum, set))
			return true;

		if (set.contains(sum - root.data)) {
			System.out.println("Pair is (" + (sum - root.data) + ", " + root.data + ")");
			return true;
		} else
			set.add(root.data);

		return findpairUtil(root.right, sum, set);
	}

	/*
	 * Define findPair method which will return appropriate message if above utility
	 * function doesn't return the pair
	 */
	static void findPair(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findpairUtil(root, sum, set))
			System.out.print("Nodes are not found.");
	}

	// Driver code
	public static void main(String[] args) {
		Node root = null;

		// Add nodes to the binary search tree
		root = insert(root, 40);
		root = insert(root, 20);
		root = insert(root, 60);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 50);
		root = insert(root, 70);

		// Define sum and initialize to a value for which a sum pair to be found
		int sum = 130;

		// Function call to return pair. with appropriate message
		findPair(root, sum);
	}

}
