package com.practice.hackerrank.datastructures.linkedlist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * [Compare two linked lists]
 * (https://www.hackerrank.com/challenges/compare-two-linked-lists/problem?isFullScreen=true)
 *
 * @author lakshay
 */
public class CompareLists {

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

  // Complete the compareLists function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */
  static boolean compareLists(SinglyLinkedListNode first, SinglyLinkedListNode second) {
    // assumes that elements will be in same order
    while (first != null && second != null) {
      if (first.data != second.data) {
        return false;
      }
      first = first.next;
      second = second.next;
    }
    // if both are null then the list is matching, otherwise not
    return first == null && second == null;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new OutputStreamWriter(System.out));

    int tests = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int testsItr = 0; testsItr < tests; testsItr++) {
      SinglyLinkedList llist1 = new SinglyLinkedList();

      int llist1Count = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llist1Count; i++) {
        int llist1Item = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist1.insertNode(llist1Item);
      }

      SinglyLinkedList llist2 = new SinglyLinkedList();

      int llist2Count = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llist2Count; i++) {
        int llist2Item = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist2.insertNode(llist2Item);
      }

      boolean result = compareLists(llist1.head, llist2.head);

      bufferedWriter.write(String.valueOf(result ? 1 : 0));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
