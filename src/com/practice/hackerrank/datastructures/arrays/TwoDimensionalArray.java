package com.practice.hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 * [2d- Array](https://www.hackerrank.com/challenges/2d-array/problem)
 *
 * @author lakshay
 */
public class TwoDimensionalArray {
  // Complete the hourglassSum function below.
  static int hourglassSum(int[][] arr) {
    // based on the input constraints start with a negative max sum
    int maxSum = -999;
    int len = arr.length;
    for (int i = 0; i < len - 2; i++) {
      for (int j = 0; j < arr[i].length - 2; j++) {
        int currentSum =
            arr[i][j]
                + arr[i][j + 1]
                + arr[i][j + 2]
                + arr[i + 1][j + 1]
                + arr[i + 2][j]
                + arr[i + 2][j + 1]
                + arr[i + 2][j + 2];
        maxSum = Math.max(currentSum, maxSum);
      }
    }
    return maxSum;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int[][] arr = new int[6][6];

    for (int i = 0; i < 6; i++) {
      String[] arrRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 6; j++) {
        int arrItem = Integer.parseInt(arrRowItems[j]);
        arr[i][j] = arrItem;
      }
    }

    int result = hourglassSum(arr);

    System.out.println(result);

    scanner.close();
  }
}
