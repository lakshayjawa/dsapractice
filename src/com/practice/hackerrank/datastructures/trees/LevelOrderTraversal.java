package com.practice.hackerrank.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * [Level order traversal](https://www.hackerrank.com/challenges/tree-level-order-traversal/problem)
 *
 * @author lakshay
 */
public class LevelOrderTraversal {

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

  /*

  class Node
      int data;
      Node left;
      Node right;
  */
  public static void levelOrder(Node root) {
    Queue<Node> q = new LinkedList<>();
    while (root != null) {
      System.out.print(root.data + " ");
      if (root.left != null) {
        q.add(root.left);
      }

      if (root.right != null) {
        q.add(root.right);
      }
      root = q.poll();
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
    levelOrder(root);
  }
}
