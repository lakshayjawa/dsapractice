## Heap Questions

- Legend
    - Difficulty
        - :green_circle: Easy
        - :orange_circle: Medium
        - :red_circle: Hard

    - :star: Important
    - :white_check_mark: Done
    - :negative_squared_cross_mark: Not done
    - :ballot_box_with_check: Read


| Difficulty       | Done                          | Solution  | Problem                                                                                                                                                                                                                                                                                                            |
| -------------    | ------------------------------ | -------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| :orange_circle:     | :white_check_mark:  | [Solution](BuildHeap.java) | [Implement a Maxheap/MinHeap using arrays and recursion.](https://www.geeksforgeeks.org/building-heap-from-array/)
| :orange_circle:     | :white_check_mark:  | [Solution](HeapSort.java) |:star: [Sort an Array using heap. (HeapSort)](https://www.geeksforgeeks.org/heap-sort/)
| :red_circle:     | :white_check_mark:  | [Solution](SlidingWindowMax.java) | :star:[Maximum of all subarrays of size k.](https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/)
| :green_circle:     | :negative_squared_cross_mark:  | [Solution](ReverseAnArray.java) | [“k” largest element in an array](https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1)
| :green_circle:     | :negative_squared_cross_mark:  | [Solution](ReverseAnArray.java) | [Kth smallest and largest element in an unsorted array](https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/)
| :green_circle:     | :negative_squared_cross_mark:  | [Solution](ReverseAnArray.java) | [Merge “K” sorted arrays. \[ IMP \]](https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1)
| :green_circle:     | :white_check_mark:  | [Solution](MergeTwoMaxHeaps.java) | [Merge 2 Binary Max Heaps](https://www.geeksforgeeks.org/merge-two-binary-max-heaps/)
| :green_circle:     | :negative_squared_cross_mark:  | [Solution](ReverseAnArray.java) | [Kth largest sum continuous subarrays](https://www.geeksforgeeks.org/k-th-largest-sum-contiguous-subarray/)
| :green_circle:     | :negative_squared_cross_mark:  | [Solution](ReverseAnArray.java) | [Leetcode- reorganize strings](https://leetcode.com/problems/reorganize-string/)
| :green_circle:     | :negative_squared_cross_mark:  | [Solution](ReverseAnArray.java) | [Merge “K” Sorted Linked Lists \[V.IMP\]](https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1)
| :green_circle:     | :negative_squared_cross_mark:  | [Solution](ReverseAnArray.java) | [Smallest range in “K” Lists](https://practice.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1)
| :green_circle:     | :negative_squared_cross_mark:  | [Solution](ReverseAnArray.java) | [Median in a stream of Integers](https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0)
| :orange_circle:     | :white_check_mark:  | [Solution](IsBinaryTreeAHeap.java) | :star: [Check if a Binary Tree is Heap](https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/)
| :green_circle:     | :negative_squared_cross_mark:  | [Solution](ReverseAnArray.java) | [Connect “n” ropes with minimum cost](https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes/0)
| :orange_circle:     | :white_check_mark:  | [Solution](BstToMinHeap.java) | [Convert BST to Min Heap](https://www.geeksforgeeks.org/convert-bst-min-heap/)
| :green_circle:     | :ballot_box_with_check:  | [Solution](#convert min heap to max heap) | [Convert min heap to max heap](https://www.geeksforgeeks.org/convert-min-heap-to-max-heap/)
| :green_circle:     | :negative_squared_cross_mark:  | [Solution](ReverseAnArray.java) | [Rearrange characters in a string such that no two adjacent are same.](https://practice.geeksforgeeks.org/problems/rearrange-characters/0)
| :green_circle:     | :negative_squared_cross_mark:  | [Solution](ReverseAnArray.java) | [Minimum sum of two numbers formed from digits of an array](https://practice.geeksforgeeks.org/problems/minimum-sum4058/1)                                                                                                                                                                                         


# Convert min heap to max heap
- Simply build Max Heap without caring about the input. 
- start from bottom-most and rightmost internal mode of min Heap and heapify all internal modes in bottom up way to build the Max heap.

