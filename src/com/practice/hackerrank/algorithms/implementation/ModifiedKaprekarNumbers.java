package com.practice.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * [Modified Kaprekar Numbers]
 * (https://www.hackerrank.com/challenges/kaprekar-numbers/problem)
 *
 * @author lakshay
 */
public class ModifiedKaprekarNumbers {

  // Complete the kaprekarNumbers function below.
  static void kaprekarNumbers(int p, int q) {
    boolean found = false;
    for (int i = p; i <= q; i++) {
      if (isKaprekarNumber(i)) {
        found = true;
      }
    }
    if (!found) {
      System.out.println("INVALID RANGE");
    }
  }

  static boolean isKaprekarNumber(int n) {
    String nStr = String.valueOf(n);
    int d = nStr.length();
    // cast to long to avoid integer overflow
    long sq = (long) n * n;
    String sqStr = String.valueOf(sq);
    int sqLen = sqStr.length();
    int numL = 0;
    int numR = 0;
    int mid = sqLen / 2;

    String left = sqStr.substring(0, mid);
    String right = sqStr.substring(mid);
    numL = left.isEmpty() ? 0 : Integer.parseInt(left);
    numR = right.isEmpty() ? 0 : Integer.parseInt(right);

    if (numL + numR == n) {
      System.out.print(n + " ");
      return true;
    }
    return false;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int p = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    kaprekarNumbers(p, q);

    scanner.close();
  }
}
