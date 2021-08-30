package com.practice.sheet.heap;

import java.util.Arrays;

/**
 * HeapSort
 *
 * @author lakshay
 */
public class HeapSort {
  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6, 7};
    heapSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  static void heapSort(int[] a) {
    buildHeap(a);
    for (int i = a.length - 1; i > 0; i--) {
      // move the current root to the end
      swap(a, i, 0);
      // passing size here makes sure that heapify happens on reduced heap
      heapify(a, i, 0);
    }
  }

  static void buildHeap(int[] a) {
      // may forget this
    int indexOfLastNonLeaf = (a.length / 2) - 1;
    for (int i = indexOfLastNonLeaf; i >= 0; i--) {
      heapify(a, a.length, i);
    }
  }

  static void heapify(int[] a, int size, int i) {
    // initialize largest to root
    int largest = i;
    // left child
    int left = 2 * i + 1;
    // right child
    int right = 2 * i + 2;
    // if left child is more than root
    if (left < size && a[left] > a[largest]) {
      largest = left;
    }
    // if right is larger than current largest
    if (right < size && a[right] > a[largest]) {
      largest = right;
    }

    // if largest index is not root
    if (largest != i) {
      // swap largest with root
      swap(a, largest, i);
      // now root is largest so recursively heapify affected subtree
      heapify(a, size, largest);
    }
  }

  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
