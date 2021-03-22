package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Palindrome Index (https://www.hackerrank.com/challenges/palindrome-index/problem)
 *
 * @author lakshay
 */
public class PalindromeIndex {
  // Complete the palindromeIndex function below.
  static int palindromeIndex(String s) {
    // [abbca] a=a, b!=c validate bbc
    int result = -1;
    int len = s.length();
    for (int i = 0; i < len / 2; i++) {
      if (s.charAt(i) != s.charAt(len - i - 1)) {
        // if the characters dont match then one of them should be removed
        if (isPalindrome(s.substring(i + 1, len - i))) {
          // if right side is palindrome
          return i;
        } else {
          return len - i - 1;
        }
      }
    }
    return result;
  }

  static boolean isPalindrome(String s) {
    int len = s.length();
    for (int i = 0; i <= len / 2; i++) {
      if (s.charAt(i) != s.charAt(len - i - 1)) {
        return false;
      }
    }
    return true;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = palindromeIndex(s);

      System.out.println(result);
    }
    scanner.close();
  }
}
