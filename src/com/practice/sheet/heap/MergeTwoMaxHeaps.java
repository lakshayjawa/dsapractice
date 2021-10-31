package com.practice.sheet.heap;

import javax.management.JMRuntimeException;
import java.util.Arrays;

/**
 * MergeTwoMaxHeaps
 *
 * @author lakshay
 */
public class MergeTwoMaxHeaps {
  public static void main(String[] args) {
    int[] a = {10, 5, 6, 2};
    int[] b = {12, 7, 9};

    int[] merged = new int[a.length + b.length];
    mergeHeaps(merged, a, b);
    System.out.println("After merge:" + Arrays.toString(merged));
  }

  private static void mergeHeaps(int[] merged, int[] a, int[] b) {
    for (int i = 0; i < a.length; i++) {
      merged[i] = a[i];
    }
    for (int i = 0; i < b.length; i++) {
      merged[i + a.length] = b[i];
    }
    for (int i = (merged.length / 2) - 1; i >= 0; i--) {
      heapify(merged, i);
    }
  }

  private static void heapify(int[] merged, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int size = merged.length;
    if (left < size && merged[left] >= merged[largest]) {
      largest = left;
    }
    if (right < size && merged[right] >= merged[largest]) {
      largest = right;
    }
    if (largest != i) {
      swap(merged, largest, i);
      heapify(merged, largest);
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
