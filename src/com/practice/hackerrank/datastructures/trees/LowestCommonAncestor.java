package com.practice.hackerrank.datastructures.trees;

import java.util.Scanner;

/**
 * [BST-lowest-common-ancestor]
 * (https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem)
 *
 * @author lakshay
 */
public class LowestCommonAncestor {
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
  public static Node lca(Node root, int v1, int v2) {
    // Write your code here.
    // root is the ancestor of all
    Node result = root;
    while (result != null) {
      if (v1 < result.data && v2 < result.data) {
        result = result.left;
      } else if (v1 > result.data && v2 > result.data) {
        result = result.right;
      } else {
        // lca = ancestor which is greater than v1 and less than v2
        break;
      }
    }
    return result;
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
    int v1 = scan.nextInt();
    int v2 = scan.nextInt();
    scan.close();
    Node ans = lca(root, v1, v2);
    System.out.println(ans.data);
  }
}
