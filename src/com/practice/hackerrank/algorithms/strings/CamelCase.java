package com.practice.hackerrank.algorithms.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Problem statement [Camel Case](https://www.hackerrank.com/challenges/camelcase/problem)
 *
 * @author lakshay
 */
public class CamelCase {
  // Complete the camelcase function below.
  static int camelcase(String s) {
    char[] ch = s.toCharArray();
    // According to problem s has length >= 1, so there will be atleast one word
    int result = 1;
    for (char c : ch) {
      if (Character.isUpperCase(c)) {
        result++;
      }
    }
    return result;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String s = scanner.nextLine();
    int result = camelcase(s);

    System.out.println(result);
    scanner.close();
  }
}
