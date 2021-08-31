package com.practice.sheet.heap;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BstToMinHeap
 *
 * @author lakshay
 */
public class BstToMinHeap {
  public static void main(String[] args) {
    //
    // BST formation
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(6);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.left = new Node(5);
    root.right.right = new Node(7);

    System.out.println("PreOrder Traversal before conversion:");
    preOrder(root);
    System.out.println();

    convertBstToMinHeap(root);

    System.out.println("PreOrderTraversal after conversion:");
    preOrder(root);
    System.out.println();
  }

  private static void convertBstToMinHeap(Node root) {
    Queue<Integer> queue = new LinkedList<>();
    convertBstToArray(root, queue);
    convertArrayToMinHeap(root, queue);
  }

  static int index = 0;

  private static void convertArrayToMinHeap(Node root, Queue<Integer> queue) {
    if (root == null) {
      return;
    }
    root.data = queue.remove();
    convertArrayToMinHeap(root.left, queue);
    convertArrayToMinHeap(root.right, queue);
  }

  private static void convertBstToArray(Node root, Queue<Integer> queue) {
    if (root != null) {
      // fill the data , the smallest is left so this results in min heap
      // if the right is added first then it would result in max heap
      convertBstToArray(root.left, queue);
      queue.add(root.data);
      convertBstToArray(root.right, queue);
    }
  }

  static void preOrder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }
  }
}
