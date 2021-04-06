package com.practice.hackerrank.datastructures.linkedlist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * [Insert at Tail](https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem)
 *
 * @author lakshay
 */
public class InsertAtTail {

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

    public SinglyLinkedList() {
      this.head = null;
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

  // Complete the insertNodeAtTail function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */
  static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    if (head == null) {
      return new SinglyLinkedListNode(data);
    }
    SinglyLinkedListNode current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = new SinglyLinkedListNode(data);
    return head;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    SinglyLinkedList llist = new SinglyLinkedList();

    int llistCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < llistCount; i++) {
      int llistItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

      llist.head = llist_head;
    }

    printSinglyLinkedList(llist.head, "\n", bufferedWriter);
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
