package com.practice.sheet.heap;

import java.util.LinkedList;
import java.util.Queue;

/**
 * IsBinaryTreeAHeap
 *
 * @author lakshay
 */
public class IsBinaryTreeAHeap {

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(9);
    root.right = new Node(8);
    root.left.left = new Node(7);
    root.left.right = new Node(6);
    root.right.left = new Node(5);
    root.right.right = new Node(4);
    root.left.left.left = new Node(3);
    root.left.left.right = new Node(2);
    root.left.right.left = new Node(1);

    // using recursion
    if (isBinaryTreeAHeap(root)) System.out.println("Given binary tree is a Heap");
    else System.out.println("Given binary tree is not a Heap");

    if (isHeapUsingLevelOrderTraversal(root)) System.out.println("Given binary tree is a Heap");
    else System.out.println("Given binary tree is not a Heap");
  }

  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
    }
  }

  static boolean isHeapUsingLevelOrderTraversal(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    // to check if binary tree is complete or not
    // A node is ‘Full Node’ if both left and right children are not empty (or not NULL).
    boolean notFullNodeFound = false;
    while (!q.isEmpty()) {
      Node temp = q.poll();
      if (temp.left != null) {
        if (notFullNodeFound || temp.left.data >= temp.data) {
          return false;
        }
        q.add(temp.left);
      } else {
        notFullNodeFound = true;
      }
      if (temp.right != null) {
        if (notFullNodeFound || temp.right.data >= temp.data) {
          return false;
        }
        q.add(temp.right);
      } else {
        notFullNodeFound = true;
      }
    }
    return true;
  }

  static boolean isBinaryTreeAHeap(Node root) {
    if (root == null) {
      return true;
    }

    int numberOfNodes = countNodes(root);

    return isCompleteBinaryTree(root, 0, numberOfNodes) && isHeapPropertySatisfied(root);
  }

  /**
   * Method returns true if max heap property is satisfied
   *
   * @param root the node
   * @return true if heap property satisfied
   */
  static boolean isHeapPropertySatisfied(Node root) {
    // for leaf
    if (root.left == null && root.right == null) {
      return true;
    }

    //  node will be in second last level
    if (root.right == null) {
      //  check heap property at Node
      //  No recursive call ,
      //  because no need to check last level
      return root.data >= root.left.data;
    } else {
      //  Check heap property at Node and
      //  Recursive check heap property at left and
      //  right subtree
      if (root.data >= root.left.data && root.data >= root.right.data) {
        return isHeapPropertySatisfied(root.left) && isHeapPropertySatisfied(root.right);
      } else {
        return false;
      }
    }
  }

  /** This function checks if the binary tree is complete or not */
  static boolean isCompleteBinaryTree(Node root, int index, int numberOfNodes) {
    // empty tree is complete
    if (root == null) {
      return true;
    }
    // If index assigned to current
    //  node is more than number of
    //  nodes in tree,  then tree is
    // not complete
    if (index >= numberOfNodes) {
      return false;
    }
    // Recur for left and right subtrees
    return isCompleteBinaryTree(root.left, 2 * index + 1, numberOfNodes)
        && isCompleteBinaryTree(root.right, 2 * index + 2, numberOfNodes);
  }

  static int countNodes(Node root) {
    if (root == null) {
      return 0;
    }
    return 1 + countNodes(root.left) + countNodes(root.right);
  }
}
