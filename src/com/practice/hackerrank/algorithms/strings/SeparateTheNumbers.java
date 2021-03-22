package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * [Separate the Numbers]
 *
 * <p>(https://www.hackerrank.com/challenges/separate-the-numbers/problem)
 *
 * <p>Technique - Rather than traversing the string, try to create a string based on constraints and
 * check if matches the string in question
 *
 * @author lakshay
 */
public class SeparateTheNumbers {

  // Complete the separateNumbers function below.
  static void separateNumbers(String s) {
    String initialStartDigit = null;
    for (int i = 1; i <= s.length() / 2; i++) {
      String start = s.substring(0, i);
      Long startDigit = Long.parseLong(start);
      StringBuilder generatedString = new StringBuilder();
      while (initialStartDigit == null) {
        long nextDigit = startDigit + 1;
        generatedString.append(startDigit);
        if (generatedString.length() == s.length()) {
          // if generated String length = string length
          if (generatedString.toString().equals(s)) {
            // check if it matches
            initialStartDigit = start;
          } else {
            break;
          }
        } else if (generatedString.length() > s.length()) {
          break;
        }
        startDigit = nextDigit;
      }
    }

    System.out.println(initialStartDigit != null ? "YES " + initialStartDigit : "NO");
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      separateNumbers(s);
    }

    scanner.close();
  }
}
