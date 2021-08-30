package com.practice.sheet.array;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;

/**
 * NegativeFirst
 *
 * @author lakshay
 */
public class NegativeFirst {
  public static void main(String[] args) {
    //
    int[] a = {-1, 8, 5, 422, 21, -2, -3, 34, -11, 2};
    System.out.println("Input: ");
    System.out.println(Arrays.toString(a));
    System.out.println("Using sorting");
    arrangeNegativeFirst(a);
    System.out.println(Arrays.toString(a));
    System.out.println("Using two pointers moving forward");
    int[] a1 = {-1, 8, 5, 422, 21, -2, -3, 34, -11, 2};
    arrangeNegativeFirstUsingTwoPointers(a1);
    System.out.println(Arrays.toString(a));
    System.out.println("Using bidirectional approach");
    int[] a2 = {-1, 8, 5, 422, 21, -2, -3, 34, -11, 2};
    rearrangeBidirectional(a2, 0, a2.length - 1);
    System.out.println(Arrays.toString(a));
  }


  /**
   * Time complexity depends on the sorting algorithm. May be O(nlog(n))
   *
   * @param a input array
   */
  static void arrangeNegativeFirst(int[] a) {
    Arrays.sort(a);
  }

  /**
   * using two pointers. Works in O(n)
   *
   * @param a input array
   */
  static void arrangeNegativeFirstUsingTwoPointers(int[] a) {
    int leftMostPositiveElementIndex = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] < 0) {
        if (i != leftMostPositiveElementIndex) { // skipping this condition will not cause issues
          // prevent unnecessary swap of same element
          swap(a, i, leftMostPositiveElementIndex);
        }
        leftMostPositiveElementIndex++;
      }
    }
  }

  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  /**
   * traverse from starting and ending of the array. Compare the elements at both pointers and swap
   * if left is positive and right is negative. If the left element is positive and the right
   * element is also positive then simply decrement the right pointer. If the left and right pointer
   * elements are negative then simply increment the left pointer.
   *
   * Time complexity s O(n).
   * @param a input array
   * @param left the left index
   * @param right the right index
   */
  static void rearrangeBidirectional(int[] a, int left, int right) {
    while (left <= right) {
      if (a[left] < 0 && a[right] < 0) {
        left++;
      } else if (a[left] > 0 && a[right] < 0) {
        swap(a, left, right);
        left++;
        right--;
      } else if (a[left] > 0 && a[right] > 0) {
        right--;
      } else {
        left++;
        right--;
      }
    }
  }
}
