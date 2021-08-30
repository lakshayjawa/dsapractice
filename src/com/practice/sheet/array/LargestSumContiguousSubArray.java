package com.practice.sheet.array;

import java.util.Arrays;

/**
 * LargestSumContigousSubArray
 *
 * @author lakshay
 */
public class LargestSumContiguousSubArray {
  public static void main(String[] args) {
    int[] a = {1, -2, 3, 4, 5, -6};
    System.out.println(Arrays.toString(a));
    System.out.println(maxSubArraySum(a));
  }

  static int maxSubArraySum(int[] a) {
    int[] sum = new int[a.length];
    int max_so_far = a[0];
    sum[0] = a[0];
    for (int i = 1; i < a.length; i++) {
      sum[i] = sum[i - 1] + a[i];
      if (sum[i] < 0) {
        sum[i] = a[i];
      }
      if (max_so_far < sum[i]) {
        max_so_far = sum[i];
      }
    }
    System.out.println(Arrays.toString(sum));
    return max_so_far;
  }
}
