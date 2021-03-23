package com.practice.hackerrank.datastructures.trees;

import java.util.Scanner;

/**
 * [In Order Traversal](https://www.hackerrank.com/challenges/tree-inorder-traversal/problem)
 *
 * <p>Left -> Root -> Right
 *
 * @author lakshay
 */
public class InOrderTraversal {
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

  /* you only have to complete the function given below.
  Node is defined as

  class Node {
      int data;
      Node left;
      Node right;
  }

  */

  public static void inOrder(Node root) {
    if (root != null) {
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
    }
  }

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
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
    inOrder(root);
  }
}
