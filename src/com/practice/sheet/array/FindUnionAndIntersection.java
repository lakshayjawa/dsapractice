package com.practice.sheet.array;

import java.util.HashSet;
import java.util.Set;

/**
 * FindUnionAndIntersection
 *
 * @author lakshay
 */
public class FindUnionAndIntersection {

  public static void main(String[] args) {
    int[] a = {7, 8, 6, 5, 41, 1, 1, 2, 2, 3, 4, 6, 7};
    int[] b = {7, 2, 4, 7, 11, 14};
    System.out.println("UnSorted Arrays: ");
    unsortedArraysUnion(a, b);
    unsortedArraysIntersection(a, b);

    int[] a1 = {1, 1, 1, 2, 2, 3, 4, 6, 7};
    int[] b1 = {2, 4, 7, 11, 14};
    System.out.println("Sorted Arrays: ");
    sortedArraysUnion(a1, b1);
    sortedArraysIntersection(a1, b1);
  }

  /**
   * Time complexity of this method is O(m+n) under the assumption that hash table search and insert
   * operations take O(1) time.
   *
   * @param a first array
   * @param b second array
   */
  static void unsortedArraysUnion(int[] a, int[] b) {
    Set<Integer> union = new HashSet<>();
    for (int i : a) {
      union.add(i);
    }

    for (int i : b) {
      union.add(i);
    }
    System.out.println("Union: " + union);
  }

  /**
   * Time complexity of this method is O(m+n) under the assumption that hash table search and insert
   * operations take O(1) time.
   *
   * @param a first array
   * @param b second array
   */
  static void unsortedArraysIntersection(int[] a, int[] b) {
    Set<Integer> first = new HashSet<>();
    for (int i : a) {
      first.add(i);
    }
    Set<Integer> intersection = new HashSet<>();
    for (int i : b) {
      if (first.contains(i)) {
        intersection.add(i);
      }
    }
    System.out.println("Intersection: " + intersection);
  }

  /**
   * This method doesn't handle duplicates. Runs in O(n)
   *
   * @param a first array
   * @param b second array
   */
  static void sortedArraysUnion(int[] a, int[] b) {
    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
      if (a[i] == b[j]) {
        System.out.print(a[i] + " ");
        i++;
        j++;
      } else if (a[i] < b[j]) {
        System.out.print(a[i] + " ");
        i++;
      } else {
        System.out.print(b[j] + " ");
        j++;
      }
    }

    while (i < a.length) {
      System.out.print(a[i] + " ");
      i++;
    }

    while (j < b.length) {
      System.out.print(b[j] + " ");
      j++;
    }
    System.out.println();
  }

  /**
   * Runs in O(n)
   *
   * @param a first array
   * @param b second array
   */
  static void sortedArraysIntersection(int[] a, int[] b) {
    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
      if (a[i] == b[j]) {
        System.out.print(a[i] + " ");
        i++;
        j++;
      } else if (a[i] < b[j]) {
        i++;
      } else {
        j++;
      }
    }
    System.out.println();
  }
}
