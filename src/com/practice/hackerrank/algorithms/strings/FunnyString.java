package com.practice.hackerrank.algorithms.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Problem- [Funny String] (https://www.hackerrank.com/challenges/funny-string/problem)
 *
 * @author lakshay
 */
public class FunnyString {

  // Complete the funnyString function below.
  static String funnyString(String s) {
    char[] ch = s.toCharArray();
    int len = ch.length;
    for (int i = 0; i < ch.length - 1; i++) {
      int forwardDiff = Math.abs(ch[i] - ch[i + 1]);
      int backDiff = Math.abs(ch[len - 1 - i] - ch[len - 2 - i]);
      System.out.println("f =" + forwardDiff + "b =" + backDiff);
      if (forwardDiff != backDiff) {
        return "Not Funny";
      }
    }
    return "Funny";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();
      String result = funnyString(s);
      System.out.println(result);
    }
    scanner.close();
  }
}
