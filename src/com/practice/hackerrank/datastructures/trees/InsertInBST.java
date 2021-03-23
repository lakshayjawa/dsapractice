package com.practice.hackerrank.datastructures.trees;

import java.util.Scanner;

/**
 * [Binary Search Tree Insertion](https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem)
 * @author lakshay
 */
public class InsertInBST {
  static class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  public static void preOrder(Node root) {

    if (root == null) return;

    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  /* Node is defined as :
  class Node
     int data;
     Node left;
     Node right;

     */

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else if (data < root.data) {
      root.left = insert(root.left, data);
    } else if (data > root.data) {
      root.right = insert(root.right, data);
    }
    return root;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    preOrder(root);
  }
}
