package com.practice.sheet.array;

import java.util.Arrays;

/**
 * Sort012
 *
 * @author lakshay
 */
public class Sort012 {
  public static void main(String[] args) {
    //
    int[] a = {1, 1, 2, 1, 0, 0, 0, 1, 2};
    System.out.println("Input = ");
    printArray(a);
    sortUsingSortingAlgorithm(a);
    printArray(a);
    System.out.println("sortWithoutSortingAlgo");
    int[] a1 = {1, 1, 2, 1, 0, 0, 0, 1, 2};
    sortWithoutSortingAlgo(a1);
    printArray(a1);
    System.out.println("sortWithoutSortingAlgoMostEfficient");
    int[] a2 = {1, 1, 2, 1, 0, 0, 0, 1, 2};
    sortWithoutSortingAlgoMostEfficient(a2);
    printArray(a2);
  }

  static void printArray(int[] a) {
    for (int i : a) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  /**
   * Time complexity depends on the sorting algorithm Can be O(nlogn)
   *
   * @param a input array
   */
  static void sortUsingSortingAlgorithm(int[] a) {
    Arrays.sort(a);
  }

  /**
   * Time Complexity: O(n) but Requires two traversals
   *
   * @param a input array
   */
  static void sortWithoutSortingAlgo(int[] a) {
    int count0 = 0, count1 = 0, count2 = 0;
    for (int i : a) {
      if (i == 0) {
        count0++;
      } else if (i == 1) {
        count1++;
      } else if (i == 2) {
        count2++;
      }
    }
    int i = 0;
    while (count0 > 0) {
      a[i++] = 0;
      count0--;
    }

    while (count1 > 0) {
      a[i++] = 1;
      count1--;
    }

    while (count2 > 0) {
      a[i++] = 2;
      count2--;
    }
  }

  /**
   * Time Complexity: O(n). Only one traversal of the array is needed. Space Complexity: O(1). No
   * extra space is required.
   *
   * @param a input array
   */
  static void sortWithoutSortingAlgoMostEfficient(int[] a) {
    int lo = 0;
    int hi = a.length - 1;
    int mid = 0;
    while (mid <= hi) {
      if (a[mid] == 0) {
        swap(a, lo, mid);
        mid++;
        lo++;
      } else if (a[mid] == 1) {
        mid++;
      } else if (a[mid] == 2) {
        swap(a, mid, hi);
        // mid++; THIS IS A MISTAKE as we don't know what element is at a[hi]
        hi--;
      }
    }
  }

  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
