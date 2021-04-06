package com.practice.hackerrank.datastructures.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * [Insert at position]
 * (https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem)
 *
 * @author lakshay
 */
public class InsertAtPosition {

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

  // Complete the insertNodeAtPosition function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */
  static SinglyLinkedListNode insertNodeAtPosition(
      SinglyLinkedListNode head, int data, int position) {
    if(position < 0){
      // nothing is inserted as we assume that position > = 0
      return head;
    }
    SinglyLinkedListNode current = head;
    SinglyLinkedListNode previous = null;
    int currentIndex = 0;
    while (currentIndex != position && current != null && current.next != null) {
      currentIndex++;
      previous = current;
      current = current.next;
    }

    if (previous != null) {
      // link previous to new node
      previous.next = new SinglyLinkedListNode(data);
      // link new node to next node
      previous.next.next = current;
    } else {
      // position is zero or head is null
      SinglyLinkedListNode temp = new SinglyLinkedListNode(data);
      temp.next = head;
      head = temp;
    }

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

      llist.insertNode(llistItem);
    }

    int data = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int position = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

    printSinglyLinkedList(llist_head, " ", bufferedWriter);
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
