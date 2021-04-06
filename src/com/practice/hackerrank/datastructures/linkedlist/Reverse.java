package com.practice.hackerrank.datastructures.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * [Reverse a Linked list]
 * (https://www.hackerrank.com/challenges/reverse-a-linked-list/problem)
 *
 * @author lakshay
 */
public class Reverse {

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

  public static void printSinglyLinkedList(
      SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }

  // Complete the reverse function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */
  static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    if (head == null) {
      return null;
    }
    SinglyLinkedListNode current = head;
    SinglyLinkedListNode previous = null;
    while (current != null) {
      SinglyLinkedListNode temp = current.next;
      current.next = previous;
      previous = current;
      current = temp;
    }

    return previous;
  }

  static SinglyLinkedListNode reverseUsingRecursion(SinglyLinkedListNode head){
      if(head == null || head.next == null){
        return head;
      }
      // recursive call to return the tail or original list
      SinglyLinkedListNode tail = reverseUsingRecursion(head.next);
      // base case -  reverse the pointers
      head.next.next = head;
      head.next = null;
      return tail;


  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

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

      SinglyLinkedListNode llist1 = reverse(llist.head);

      printSinglyLinkedList(llist1, " ", bufferedWriter);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
