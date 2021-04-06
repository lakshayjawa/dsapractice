package com.practice.hackerrank.datastructures.linkedlist;

import java.util.Scanner;
import java.util.Stack;

/**
 * [Print In Reverse]
 * (https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem)
 *
 * @author lakshay
 */
public class PrintInReverse {

  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }

      this.tail = node;
    }
  }

  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
    while (node != null) {
      System.out.print(node.data);

      node = node.next;

      if (node != null) {
        System.out.print(sep);
      }
    }
  }

  // Complete the reversePrint function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *  Easiest way using recursion
   *
   */
  static void reversePrint(SinglyLinkedListNode head) {
    if (head != null) {
      reversePrint(head.next);
      System.out.println(head.data);
    }
  }

  /*
   * Another way using stack
   */
  static void reversePrintUsingStack(SinglyLinkedListNode head) {
    Stack<SinglyLinkedListNode> stack = new Stack<>();
    SinglyLinkedListNode current = head;
    while (current != null) {
      stack.push(current);
      current = current.next;
    }
    while (!stack.isEmpty()) {
      System.out.println(stack.pop().data);
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int tests = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int testsItr = 0; testsItr < tests; testsItr++) {
      SinglyLinkedList llist = new SinglyLinkedList();

      int llistCount = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llistCount; i++) {
        int llistItem = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist.insertNode(llistItem);
      }

      reversePrint(llist.head);
    }

    scanner.close();
  }
}
