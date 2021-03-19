package com.practice.hackerrank.algorithms.strings;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class CaesarCipher {
  // Complete the caesarCipher function below.
  static String caesarCipher(String s, int k) {
    // cases where k > 26
    k = k % 26;
    char[] ch = s.toCharArray();
    StringBuilder result = new StringBuilder();
    for (char c : ch) {
      if (Character.isAlphabetic(c)) {
        if (Character.isUpperCase(c) && Character.isUpperCase((char) (c + k))) {
          // Upper case letters need to be replace with Upper case
          result.append((char) (c + k));
        } else if (Character.isLowerCase(c) && Character.isLowerCase((char) (c + k))) {
          // Lower case letters need to be replace with Lower case
          result.append((char) (c + k));
        } else {
          // if case doesn't match then rotate it within the case range
          result.append((char) (c - 26 + k));
        }
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    String s = scanner.nextLine();
    int k = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    String result = caesarCipher(s, k);
    System.out.println(result);
    scanner.close();
  }
}
