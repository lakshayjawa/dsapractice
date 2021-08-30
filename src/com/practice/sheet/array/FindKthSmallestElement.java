package com.practice.sheet.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * FindKthSmallestElement
 *
 * @author lakshay
 */
public class FindKthSmallestElement {

  public static void main(String[] args) {
    //
    int[] a = {23, 2, 21, 231, 12, 36, 76};
    int k = 3;
    System.out.println(Arrays.toString(a));
    System.out.println("K = " + k + " smallest element = " + findKthSmallestUsingSorting(a, k));
    System.out.println("K = " + k + " smallest element = " + findKthSmallestUsingMinHeap(a, k));
    int[] x = {23, 2, 21, 231, 12, 36, 76};
    System.out.println(
        "K = "
            + k
            + " smallest element = "
            + findKthSmallestUsingRandomizedQuickSelect(x, 0, x.length - 1, k));
  }


  /**
   * A simple solution is to sort the given array using a O(N log N) sorting algorithm like Merge
   * Sort, Heap Sort, etc, and return the element at index k-1 in the sorted array. Time Complexity
   * of this solution is O(N Log N)
   *
   * @param a, input array
   * @param k, k
   * @return kth - smallest element
   */
  static int findKthSmallestUsingSorting(int[] a, int k) {
    Arrays.sort(a);
    // handle k > a.length
    // k = k % a.length;
    return a[k - 1];
  }

  /**
   * Time complexity of this solution is O(n + kLogn).
   *
   * @param a, the input array
   * @param k, k
   * @return kth - smallest element
   */
  static int findKthSmallestUsingMinHeap(int[] a, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int result = -1;
    for (int i : a) {
      heap.add(i);
    }
    for (int i = 0; i < k; i++) {
      result = heap.poll();
    }
    return result;
  }

  /**
   * This is an optimization over method 1 if QuickSort is used as a sorting algorithm in first
   * step. In QuickSort, we pick a pivot element, then move the pivot element to its correct
   * position and partition the surrounding array. The idea is, not to do complete quicksort, but
   * stop at the point where pivot itself is k’th smallest element. Also, not to recur for both left
   * and right sides of pivot, but recur for one of them according to the position of pivot. The
   * worst case time complexity of this method is O(n2), but it works in O(n) on average.
   *
   * <p>Assumption: all elements are distinct
   *
   * @param a input array
   * @param low low
   * @param high high
   * @param k k
   * @return k'th smallest element
   */
  static int findKthSmallestUsingRandomizedQuickSelect(int[] a, int low, int high, int k) {

    if (k > 0 && k <= high - low + 1) {
      int pos = randomPartition(a, low, high);
      // pivot selection is randomized using above method.
      // we can use below line and comment the above one to use a simpler implementation
      // int pos = partition(a, low, high);
      System.out.println("pos=" + pos);
      if (pos - low == k - 1) {
        return a[pos];
      }

      if (pos - low > k - 1) {
        return findKthSmallestUsingRandomizedQuickSelect(a, low, pos - 1, k);
      }
      return findKthSmallestUsingRandomizedQuickSelect(a, pos + 1, high, k - pos + low - 1);
    }
    return -1;
  }

  /**
   * Standard partition process of QuickSort. It considers the last element as pivot and moves all
   * smaller element to left of it and greater elements to right
   *
   * @param a the input array
   * @param low the low
   * @param high the high
   * @return index of the pivot
   */
  private static int partition(int[] a, int low, int high) {
    int pivot = a[high], i = low;
    for (int j = low; j < high; j++) {
      if (a[j] <= pivot) {
        swap(a, i, j);
        i++;
      }
    }
    swap(a, i, high);
    return i;
  }

  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  static int randomPartition(int[] a, int low, int high) {
    int numberOfElements = high - low + 1;
    int pivotIndex = new Random().nextInt(numberOfElements);
    swap(a, low + pivotIndex, high);
    return partition(a, low, high);
  }
}
