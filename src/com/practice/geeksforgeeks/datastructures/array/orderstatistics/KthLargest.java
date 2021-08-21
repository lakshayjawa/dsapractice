package com.practice.geeksforgeeks.datastructures.array.orderstatistics;

import java.util.PriorityQueue;

/** @author lakshay */
public class KthLargest {

  static int kthLargestSum(int arr[], int n, int k) {
    int result = 0;
    int[] sum = new int[n + 1];
    sum[0] = 0;
    sum[1] = arr[0];
    for (int i = 2; i <= n; i++){
      sum[i] = sum[i - 1] + arr[i - 1];
      System.out.println(sum[i]);
    }

    // priority_queue of min heap
    PriorityQueue<Integer> Q = new PriorityQueue<Integer>();

    // loop to calculate the contiguous subarray
    // sum position-wise
    for (int i = 1; i <= n; i++) {

      // loop to traverse all positions that
      // form contiguous subarray
      for (int j = i; j <= n; j++) {
        // calculates the contiguous subarray
        // sum from j to i index
        int x = sum[j] - sum[i - 1];

        // if queue has less then k elements,
        // then simply push it
        if (Q.size() < k) Q.add(x);
        else {
          // it the min heap has equal to
          // k elements then just check
          // if the largest kth element is
          // smaller than x then insert
          // else its of no use
          if (Q.peek() < x) {
            Q.poll();
            Q.add(x);
          }
        }
      }
    }

    // the top element will be then kth
    // largest element
    return Q.poll();

    //return result;
  }

  public static void main(String[] args) {
    //
    //int[] a = {20, -5, -1};
    //int k = 3;
    int[] a = {10, -10, 20, -40};
    int k = 6;
    System.out.println(kthLargestSum(a, a.length, k));
  }
}
