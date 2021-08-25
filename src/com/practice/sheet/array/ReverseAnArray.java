package com.practice.sheet.array;

/**
 * ReverseAnArray
 *
 * @author lakshay
 */
public class ReverseAnArray {
  public static void main(String[] args) {
    //
    int[] arr = {1, 2, 3, 4, 5};
    printArray(arr);
    reverseArray(arr);
    System.out.println("Reversed Array  is:");
    printArray(arr);
    reverseArrayRecursive(arr, 0, arr.length - 1);
    System.out.println("Reversed Array using recursion is:");
    printArray(arr);
  }

  static void reverseArray(int[] arr) {
    int start = 0;
    int end = arr.length - 1;

    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  static void reverseArrayRecursive(int[] arr, int start, int end) {
    if (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      reverseArrayRecursive(arr, ++start, --end);
    }
  }

  static void printArray(int[] arr) {
    for (int j : arr) {
      System.out.print(j);
    }
    System.out.println();
  }
}
