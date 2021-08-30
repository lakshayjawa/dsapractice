package com.practice.sheet.array;

import java.util.Arrays;

/**
 * RotateByOne
 *
 * @author lakshay
 */
public class RotateByOne {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7};
    rotateByOne(a);
    System.out.println(Arrays.toString(a));
  }

  static void rotateByOne(int[] a) {
    int x = a[a.length - 1];
    for (int i = a.length - 1; i > 0; i--) {
      a[i] = a[i - 1];
    }
    a[0] = x;
  }

}
