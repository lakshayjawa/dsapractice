package com.practice.sheet.heap;

import java.util.Arrays;

/**
 * BuildHeap
 *
 * @author lakshay
 */
public class BuildHeap {

  public static void main(String[] args) {
    int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
    buildHeap(arr);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * A complete binary tree is a binary tree in which every level, except possibly the last, is
   * completely filled, and all nodes are as far left as possible (Source Wikipedia)
   *
   * <p>A Binary Heap is a Complete Binary Tree where items are stored in a special order such that
   * the value in a parent node is greater(or smaller) than the values in its two children nodes.
   * The former is called max heap and the latter is called min-heap. The heap can be represented by
   * a binary tree or array.
   *
   * <p>The leaf nodes need not to be heapified as they already follow the heap property. Also, the
   * array representation of the complete binary tree contains the level order traversal of the
   * tree.
   *
   * <p>So the idea is to find the position of the last non-leaf node and perform the heapify
   * operation of each non-leaf node in reverse level order.
   *
   * <p>Heapify procedure can be applied to a node only if its children nodes are heapified. So the
   * heapification must be performed in the bottom-up order.
   *
   * <p>Time Complexity: Heapify a single node takes O(log N) time complexity where N is the total
   * number of Nodes. Therefore, building the entire Heap will take N heapify operations and the
   * total time complexity will be O(N*logN).
   *
   * @param a input array
   */
  private static void buildHeap(int[] a) {
    // Last non-leaf node = parent of last-node =  parent of node at (n-1)th index.
    //  Last non-leaf node = Node at index ((n-1) - 1)/2  = (n/2) - 1.
    int indexOfLastNonLeafNode = (a.length / 2) - 1;

    for (int i = indexOfLastNonLeafNode; i >= 0; i--) {
      heapify(a, i);
    }
  }

  /**
   * Why array based representation for Binary Heap? Since a Binary Heap is a Complete Binary Tree,
   * it can be easily represented as an array and the array-based representation is space-efficient.
   *
   * <p>If the parent node is stored at index I, the left child can be calculated by 2 * I + 1 and
   * the right child by 2 * I + 2 (assuming the indexing starts at 0).
   *
   * @param a input array
   * @param i index to heapify
   */
  private static void heapify(int[] a, int i) {
    int largest = i;
    int leftChild = 2 * i + 1;
    int rightChild = 2 * i + 2;
    // find the largest of root, left child and right child

    // If left child is larger than root
    if (leftChild < a.length && a[leftChild] > a[largest]) {
      largest = leftChild;
    }
    // If right child is larger than largest so far
    if (rightChild < a.length && a[rightChild] > a[largest]) {
      largest = rightChild;
    }

    // If largest is not root
    if (largest != i) {

      swap(a, largest, i);
      // Recursively heapify the affected sub-tree
      heapify(a, largest);
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
