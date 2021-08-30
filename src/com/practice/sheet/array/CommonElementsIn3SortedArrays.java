package com.practice.sheet.array;

import java.util.*;

/**
 * CommonElementsIn3SortedArrays
 *
 * @author lakshay
 */
public class CommonElementsIn3SortedArrays {
  public static void main(String[] args) {
    int[] ar1 = {1, 5, 10, 20, 40, 80};
    int[] ar2 = {6, 7, 20, 80, 100};
    int[] ar3 = {3, 4, 15, 20, 30, 70, 80, 120};

    System.out.println(Arrays.toString(ar1));
    System.out.println(Arrays.toString(ar2));
    System.out.println(Arrays.toString(ar3));

    System.out.println("Common Elements are:");
    commonElements(ar1, ar2, ar3);
  }

  /**
   * Works in O(n). Can be solved using sets or hash maps (key as integer and value as ) but, that
   * approach will not be able to handle duplicate elements in the same array without wasting space.
   *
   * @param a first array
   * @param b second array
   * @param c third array
   */
  static void commonElements(int[] a, int[] b, int[] c) {
    int i = 0, j = 0, k = 0;
    while (i < a.length && j < b.length && k < c.length) {
      if (a[i] == b[j] && b[j] == c[k]) {
        // equal elements
        System.out.print(a[i] + " ");
        i++;
        j++;
        k++;
      } else if (a[i] < b[j]) {
        i++;
      } else if (b[j] < c[k]) {
        j++;
      } else {
        k++;
      }
    }
  }
}
