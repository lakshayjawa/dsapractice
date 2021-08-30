package com.practice.sheet.heap;

import java.util.*;

/**
 * SlidingWindowMax
 *
 * @author lakshay
 */
public class SlidingWindowMax {
  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int k = 3;
    System.out.println("Brute Force");
    printKMax(arr, k);
    System.out.println("Using Heap");
    findKMaxUsingHeap(arr, k);
    System.out.println("Using Deque");
    printKMaxUsingDeque(arr, k);
  }

  /**
   * find the maximum for each and every contiguous sub-array of size k
   *
   * <p>Time Complexity: O(N * K)
   *
   * <p>Outer loop runs n-k+1 times and the inner loop runs k times for every iteration of outer
   * loop. So time complexity is O((n-k+1)*k) which can also be written as O(N * K). Space
   * Complexity: O(1)
   *
   * @param a input array
   * @param k size of window / sub-array size
   */
  static void printKMax(int[] a, int k) {
    int max = -1;
    for (int i = 0; i <= a.length - k; i++) {
      max = a[i];
      for (int j = i; j < i + k; j++) {
        max = Math.max(max, a[j]);
      }

      System.out.println("Max: " + max);
    }
  }

  /**
   * Time Complexity: O(N * Log k). Insertion, deletion and search takes log k time in a AVL tree.
   * So the overall time Complexity is O(N * log k) Space Complexity: O(k). The space required to
   * store k elements in a BST is O(k).
   *
   * @param a
   * @param k
   */
  static void findKMaxUsingHeap(int[] a, int k) {
    // max heap
    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    List<Integer> result = new ArrayList<>();
    // add the first k elements
    for (int i = 0; i < k; i++) {
      q.add(a[i]);
    }
    // insert the max element of first window
    result.add(q.peek());

    // remove the first element
    q.remove(a[0]);

    for (int i = k; i < a.length; i++) {
      // add the element to heap
      q.add(a[i]);
      // insert the max element to result
      result.add(q.peek());
      // remove the element from the front
      q.remove(a[i - k + 1]);
    }
    System.out.println(result);
  }

  /**
   * Time Complexity: O(n). It seems more than O(n) at first look. It can be observed that every
   * element of array is added and removed at most once. So there are total 2n operations. Auxiliary
   * Space: O(k). Elements stored in the dequeue take O(k) space.
   *
   * @param a
   * @param k
   */
  static void printKMaxUsingDeque(int[] a, int k) {
    // Create a Double Ended Queue, deque
    // that will store indexes of array elements
    // The queue will store indexes of
    // useful elements in every window and it will
    // maintain decreasing order of values
    // from front to rear in deque, i.e.,
    // arr[deque.front[]] to arr[deque.rear()]
    // are sorted in decreasing order
    Deque<Integer> dq = new LinkedList<>();
    /* Process first k (or first window)
    elements of array */
    for (int i = 0; i < k; i++) {
      // For every element, the previous
      // smaller elements are useless so
      // remove them from deque
      while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
        dq.removeLast();
      }
      // Add new element at rear of queue
      dq.addLast(i);
    }
    // Process rest of the elements,
    // i.e., from arr[k] to arr[n-1]
    for (int i = k; i < a.length; i++) {
      // The element at the front of the
      // queue is the largest element of
      // previous window, so print it
      System.out.print(a[dq.peek()] + " ");
      // Remove the elements which
      // are out of this window
      while (!dq.isEmpty() && dq.peek() <= i - k) {
        dq.removeFirst();
      }
      // Remove all elements smaller
      // than the currently
      // being added element (remove
      // useless elements)
      while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
        dq.removeLast();
      }

      // Add current element at the rear of deque
      dq.addLast(i);
    }
    // Print the maximum element of last window
    System.out.print(a[dq.peek()]);
  }
}
