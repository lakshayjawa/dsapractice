package com.practice.sheet.array;

import java.sql.SQLOutput;

/**
 * FindMaxMin
 *
 * @author lakshay
 */
public class FindMaxMin {
  static class Pair {
    int max;
    int min;
  }

  public static void main(String[] args) {
    //
    int[] a = {10, 20, 3, 30, 1000, 99};
    System.out.println("Input: ");
    printArray(a);
    Pair p = findMaxMinUsingLinearSearch(a);
    if (p != null) {
      System.out.println("Max is: " + p.max + " Min is: " + p.min);
    }
    System.out.println("Using tournament method (Divide n Conquer)");
    Pair recursive = findMinMaxByTournamentMethod(a, 0, a.length - 1);
    System.out.println("Max is: " + recursive.max + " Min is: " + recursive.min);
  }

  static void printArray(int[] a) {
    for (int i : a) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  /**
   * In this method, the total number of comparisons is 1 + 2(n-2) in the worst case and 1 + n – 2
   * in the best case. In the above implementation, the worst case occurs when elements are sorted
   * in descending order and the best case occurs when elements are sorted in ascending order.
   *
   * @param a, the input array
   * @return max min Pair
   */
  static Pair findMaxMinUsingLinearSearch(int[] a) {
    if (a.length == 0) {
      System.out.println("No elements in the array");
      return null;
    }
    Pair p = new Pair();
    p.max = a[0];
    p.min = a[0];
    for (int i = 1; i < a.length; i++) {
      p.max = Math.max(p.max, a[i]);
      p.min = Math.min(p.min, a[i]);
    }

    return p;
  }

  static Pair findMinMaxByTournamentMethod(int[] a, int low, int high) {
    Pair res = new Pair();
    Pair left = new Pair();
    Pair right = new Pair();
    // if one element
    if (low == high) {
      res.max = a[low];
      res.min = a[low];
      return res;
    }

    // if 2 elements
    if (high == low + 1) {
      res.max = Math.max(a[low], a[high]);
      res.min = Math.min(a[low], a[high]);
    }

    // if more than 2 elements
    int mid = (low + high) / 2;
    left = findMinMaxByTournamentMethod(a, low, mid);
    right = findMinMaxByTournamentMethod(a, mid + 1, high);

    res.min = Math.min(left.min, right.min);
    res.max = Math.max(left.max, right.max);
    return res;
  }
}
