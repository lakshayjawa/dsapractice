package com.practice.sheet.linkedlist;

import java.util.Stack;

/**
 * ReverseALinkedList
 *
 * @author lakshay
 */
public class ReverseALinkedList {
  Node head;

  static class Node {
    int data;
    Node next;

    Node(int d) {
      this.data = d;
      next = null;
    }
  }

  Node reverseIterative(Node node) {
    Node prev = null;
    Node curr = node;
    Node next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    // curr will be null, so return last node
    return prev;
  }

  Node reverseUsingStack(Node head) {
    Stack<Node> stack = new Stack<>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    Node newHead = stack.pop();
    Node prev = newHead;
    while (!stack.isEmpty()) {
      Node current = stack.pop();
      prev.next = current;
      prev = current;
      current.next = null;
    }

    return newHead;
  }

  Node reverseUsingRecursion(Node current, Node prev){
    if(current == null){
      return null;
    }

    if(current.next == null){
      current.next = prev;
      return current;
    }
    Node next = current.next;
    current.next = prev;
    reverseUsingRecursion(next,current);
    return current;
  }

  public static void main(String[] args) {
    ReverseALinkedList list = new ReverseALinkedList();
    list.head = new Node(1);
    list.head.next = new Node(2);
    list.head.next.next = new Node(3);
    list.head.next.next.next = new Node(4);
    list.head.next.next.next.next = new Node(5);
    list.printList(list.head);
    System.out.println("Using iteration");
    Node reversed = list.reverseIterative(list.head);
    list.printList(reversed);
    // System.out.println(list.head.data);
    System.out.println("Using stack");
    reversed = list.reverseUsingStack(reversed);
    list.printList(reversed);
  }

  void printList(Node head) {
    while (head != null) {
      System.out.print(head.data);
      head = head.next;
    }
    System.out.println();
  }
}
