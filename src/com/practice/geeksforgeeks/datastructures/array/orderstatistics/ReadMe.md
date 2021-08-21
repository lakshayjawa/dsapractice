##Array | Order Statistics

Legend | Key
------ |----
UnRead | [ ]
Read   | R
Coded  | C

Number | Status | Difficulty | Problem
------ | ------| -----------| -------
 1 | R | Easy | K’th Smallest/Largest Element in Unsorted Array | Set 1


1. [X] [K’th Smallest/Largest Element in Unsorted Array | Set 1](https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/)
    - **Solution**:  
      - O(N log N) sorting algorithm like Merge Sort, Heap Sort, etc, and return the element at index k-1 in the sorted array.
      - Using Min Heap/ Priority Queue. Create a Min Heap of the given n elements and call extractMin() k times.  Time complexity of this solution is O(n + kLogn).

2. [X] [K’th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear Time)](https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time-2/)
    - Solution: Different approach to 1. Can be ignored
    

3. [X] [K’th Smallest/Largest Element in Unsorted Array | Set 3 (Worst Case Linear Time)](https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/)
    - Solution: Different approach to 1. Can be ignored
    

4. [X] [K’th Smallest/Largest Element using STL](https://www.geeksforgeeks.org/kth-smallestlargest-element-using-stl/)
    - Solution: Same as 1, but in C++ Ignored
    

5. [X] [k largest(or smallest) elements in an array | added Min Heap method](https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/)
    - Solution:
      1. Method 3(Use Sorting) Sort the elements in descending order in O(n*log(n)). Print the first k numbers of the sorted array O(k).
      2. Add elements to max/min heap and poll k times. O(n + k*log(n)). For further optimization, we can restrict heap to size k. We add k elements to heap and then further additions are done only based on comparing the current element by root.  
    

6. [XX] [Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1](https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/)
    - Solution:


7. [X] [Program to find largest element in an array](https://www.geeksforgeeks.org/c-program-find-largest-element-array/)
    - Time Complexity- O(n)

8. [X] [Find the largest three elements in an array](https://www.geeksforgeeks.org/find-the-largest-three-elements-in-an-array/)
    - Solution:
      1. An efficient way to solve this problem is to use any O(nLogn) sorting algorithm & simply returning the last 3 largest elements. (Remember to handle duplicates)
      2. O(n) - Initialize 3 variables and loop through the array and assign the values accordingly.

9. [X]  [Find all elements in array which have at-least two greater elements](https://www.geeksforgeeks.org/find-elements-array-least-two-greater-elements/)
    - Solution:
        1. Brute Force O(n^2)
        2. Time Complexity: O(n Log n) - sort the array first in increasing order, then we print first n-2 elements where n is size of array
        3. O(n) - calculate the second maximum element of the array and print all element which is less than or equal to the second maximum.
    

10. [X] [Program for Mean and median of an unsorted array](https://www.geeksforgeeks.org/program-for-mean-and-median-of-an-unsorted-array/)
    - Solution:
      - Mean of an array = (sum of all elements) / (number of elements) Time Complexity to find mean = O(n)
      - Median of a sorted array of size n is defined as the middle element when n is odd and average of middle two elements when n is even.
        Time Complexity to find median = O(n Log n) as we need to sort the array first

11. [XX] **Hard** [Median of Stream of Running Integers using STL](https://www.geeksforgeeks.org/median-of-stream-of-running-integers-using-stl/)
    - Solution:
         - Approach: The idea is to use max heap and min heap to store the elements of higher half and lower half. Max heap and min heap can be implemented using priority_queue in C++ STL. Below is the step by step algorithm to solve this problem.
         - Algorithm:
              - Create two heaps. One max heap to maintain elements of lower half and one min heap to maintain elements of higher half at any point of time..
              - Take initial value of median as 0.
              - For every newly read element, insert it into either max heap or min-heap and calculate the median based on the following conditions: 
                - If the size of max heap is greater than the size of min-heap and the element is less than the previous median then pop the top element from max heap and insert into min-heap and insert the new element to max heap else insert the new element to min-heap. Calculate the new median as the average of top of elements of both max and min heap.
                - If the size of max heap is less than the size of min-heap and the element is greater than the previous median then pop the top element from min-heap and insert into the max heap and insert the new element to min heap else insert the new element to the max heap. Calculate the new median as the average of top of elements of both max and min heap.
                - If the size of both heaps is the same. Then check if the current is less than the previous median or not. If the current element is less than the previous median then insert it to the max heap and a new median will be equal to the top element of max heap. If the current element is greater than the previous median then insert it to min-heap and new median will be equal to the top element of min heap.
    
12. [XX] [Minimum product of k integers in an array of positive Integers](https://www.geeksforgeeks.org/minimum-product-k-integers-array-positive-integers/)
    - Solution:
      - Time Complexity : O(n * log n)  find the smallest k elements and print multiplication of them.
    
13. [XX] [K-th Largest Sum Contiguous Subarray](https://www.geeksforgeeks.org/k-th-largest-sum-contiguous-subarray/)
    - Solution:

14. [K maximum sum combinations from two arrays](https://www.geeksforgeeks.org/k-maximum-sum-combinations-two-arrays/)
    - Solution:

15. [K maximum sums of overlapping contiguous sub-arrays](https://www.geeksforgeeks.org/k-maximum-sum-overlapping-contiguous-sub-arrays/)
    - Solution:

16. [K maximum sums of non-overlapping contiguous sub-arrays](https://www.geeksforgeeks.org/k-maximum-sums-non-overlapping-contiguous-sub-arrays/)
    - Solution:

17. [k smallest elements in same order using O(1) extra space](https://www.geeksforgeeks.org/k-smallest-elements-order-using-o1-extra-space/)
    - Solution:

18. [Find k pairs with smallest sums in two arrays](https://www.geeksforgeeks.org/find-k-pairs-smallest-sums-two-arrays/)
    - Solution:

19. [k-th smallest absolute difference of two elements in an array](https://www.geeksforgeeks.org/k-th-smallest-absolute-difference-two-elements-array/)
    - Solution:

20. [Find Second largest element in an array](https://www.geeksforgeeks.org/find-second-largest-element-array/)
    - Solution:

21. [Find k numbers with most occurrences in the given array](https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/)
    - Solution:

22. [Find the smallest and second smallest elements in an array](https://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/)
    - Solution:

23. [Find the smallest missing number](https://www.geeksforgeeks.org/find-the-first-missing-number/)
    - Solution:

24. [Maximum sum such that no two elements are adjacent](https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/)
    - Solution:

25. [Maximum and minimum of an array using minimum number of comparisons](https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/)
    - Solution:

26. [Maximum difference between two elements such that larger element appears after the smaller number](https://www.geeksforgeeks.org/maximum-difference-between-two-elements/)
    - Solution:

27. [Given an array arr[], find the maximum j – i such that arr[j] &gt; arr[i]](https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/)
    - Solution:

28. [Maximum of all subarrays of size k](https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/)
    - Solution:

29. [Find the minimum distance between two numbers](https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/)
    - Solution:

30. [Find the maximum element in an array which is first increasing and then decreasing](https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/)
    - Solution:

31. [Count smaller elements on right side](https://www.geeksforgeeks.org/count-smaller-elements-on-right-side/)
    - Solution:

32. [Longest Monotonically Increasing Subsequence Size (N log N)](https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/)
    - Solution:

33. [Find the smallest positive number missing from an unsorted array | Set 1](https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/)
    - Solution:

34. [Find the maximum repeating number in O(n) time and O(1) extra space](https://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/)
    - Solution:

35. [Given an array of of size n and a number k, find all elements that appear more than n/k times](https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/)
    - Solution:

36. [Find the Increasing subsequence of length three with maximum product](https://www.geeksforgeeks.org/increasing-subsequence-of-length-three-with-maximum-product/)
    - Solution:

37. [Maximum Sum Path in Two Arrays](https://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/)
    - Solution:

38. [Find the closest pair from two sorted arrays](https://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/)
    - Solution:

39. [Find the largest pair sum in an unsorted array](https://www.geeksforgeeks.org/find-the-largest-pair-sum-in-an-unsorted-array/)
    - Solution:

40. [Smallest greater elements in whole array](https://www.geeksforgeeks.org/smallest-greater-elements-in-whole-array/)
    - Solution:

41. [Delete array elements which are smaller than next or become smaller](https://www.geeksforgeeks.org/delete-array-elements-which-are-smaller-than-next-or-become-smaller/)
    - Solution:

42. [Online algorithm for checking palindrome in a stream](https://www.geeksforgeeks.org/online-algorithm-for-checking-palindrome-in-a-stream/)
    - Solution:

43. [Delete array elements which are smaller than next or become smaller](https://www.geeksforgeeks.org/delete-array-elements-which-are-smaller-than-next-or-become-smaller/)
    - Solution:

44. [Find zeroes to be flipped so that number of consecutive 1’s is maximized](https://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of-consecutive-1s-is-maximized/)
    - Solution:

45. [Count Strictly Increasing Subarrays](https://www.geeksforgeeks.org/count-strictly-increasing-subarrays/)
    - Solution:

46. [K’th largest element in a stream](https://www.geeksforgeeks.org/kth-largest-element-in-a-stream/)
    - Solution:

47. [Find k pairs with smallest sums in two arrays](https://www.geeksforgeeks.org/find-k-pairs-smallest-sums-two-arrays/)
    - Solution:

48. [Maximum difference between group of k-elements and rest of the array.](https://www.geeksforgeeks.org/maximum-difference-group-k-elements-rest-array/)
    - Solution:

49. [Minimum number of elements to add to make median equals x](https://www.geeksforgeeks.org/minimum-number-elements-add-make-median-equals-x/)
    - Solution:

50. [Next Greater Element](https://www.geeksforgeeks.org/next-greater-element/)
    - Solution: 

