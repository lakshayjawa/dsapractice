package com.practice.hackerrank.datastructures.trees;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [Tree Top View] (https://www.hackerrank.com/challenges/tree-top-view/problem)
 *
 * @author lakshay
 */
public class TopView {

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
  static class NodeAndLevel {
    private Node node;
    private int level;

    public NodeAndLevel(Node node, int level) {
      this.node = node;
      this.level = level;
    }

    public Node getNode() {
      return this.node;
    }

    public int getLevel() {
      return this.level;
    }
  }

  public static void topView(Node root) {
    if (root == null) {
      return;
    }
    Map<Integer, Integer> levelMap = new TreeMap<>();
    Queue<NodeAndLevel> q = new LinkedList<>();
    q.add(new NodeAndLevel(root, 0));
    int level = 0;
    while (q.size() > 0) {
      NodeAndLevel n = q.poll();
      levelMap.putIfAbsent(n.getLevel(), n.getNode().data);
      if (n.getNode().left != null) {
        q.add(new NodeAndLevel(n.getNode().left, n.getLevel() - 1));
      }
      if (n.getNode().right != null) {
        q.add(new NodeAndLevel(n.getNode().right, n.getLevel() + 1));
      }
    }
    for (Integer i : levelMap.values()) {
      System.out.print(i + " ");
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
    topView(root);
  }
}
