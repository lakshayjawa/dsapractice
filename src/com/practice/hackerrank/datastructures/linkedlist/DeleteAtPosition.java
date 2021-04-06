package com.practice.hackerrank.datastructures.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * [Delete At Position]
 * (https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem)
 *
 * @author lakshay
 */
public class DeleteAtPosition {

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

  // Complete the deleteNode function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */
  static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
    if(position < 0 ){
      // don't delete anything
      return head;
    }
    if(position == 0){
      // depends on head
      return head != null ? head.next : null;
    }

    // position > 0
    int currentIndex = 1;
    SinglyLinkedListNode current = head.next;
    SinglyLinkedListNode previous = head;
    // here the position is zero based
    while (current.next != null && currentIndex != position) {
      currentIndex++;
      previous = current;
      current = current.next;
    }

    if(position > currentIndex){
      // can also throw exception or don't delete anything
      return head;
    }
    // else link previous to next
    previous.next = current.next;
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

    int position = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    SinglyLinkedListNode llist1 = deleteNode(llist.head, position);

    printSinglyLinkedList(llist1, " ", bufferedWriter);
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
