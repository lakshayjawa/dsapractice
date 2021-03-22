package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * [Hacker Rank String]
 * (https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem)
 *
 * @author lakshay
 */
public class HackerRankString {

  // Complete the hackerrankInString function below.
  static String hackerrankInString(String s) {
    char[] hr = "hackerrank".toCharArray();
    if (s.length() < hr.length) {
      return "NO";
    }
    int hrIndex = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == hr[hrIndex]) {
        hrIndex++;
      }
      if (hrIndex == hr.length) {
        return "YES";
      }
    }

    return "NO";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();
      String result = hackerrankInString(s);
      System.out.println(result);
    }
    scanner.close();
  }
}
