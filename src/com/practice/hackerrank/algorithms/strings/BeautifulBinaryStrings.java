package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Problem https://www.hackerrank.com/challenges/beautiful-binary-string/problem
 *
 * @author lakshay
 */
public class BeautifulBinaryStrings {
  // Complete the beautifulBinaryString function below.
  static int beautifulBinaryString(String b) {
    // strategy is to locate the index of zeros and find out the number of changes required
    int previousZeroIndex = -1;
    int result = 0;
    for (int i = 0; i < b.length(); i++) {
      char c = b.charAt(i);
      if (c == '0') {
        if (previousZeroIndex == -1) {
          // to start finding next 010
          previousZeroIndex = i;
        } else if (i - previousZeroIndex == 2) {
          // pattern 010
          result++;
          previousZeroIndex = -1;
        } else if (i - previousZeroIndex == 1) {
          // consecutive zero's
          previousZeroIndex = i;
        } else if (i - previousZeroIndex > 2) {
          // zeros after consecutive one's
          previousZeroIndex = i;
        }
      }
    }
    return result;
  }

  // another solution for same problem, faster to code
  static int minSteps(int n, String strB) {
    int stepsCount = 0;
    String tmpStr = strB;
    while (tmpStr.contains("010")) {
      tmpStr = tmpStr.replaceFirst("010", "011");
      stepsCount++;
    }
    return stepsCount;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    String b = scanner.nextLine();
    int result = beautifulBinaryString(b);
    System.out.println(result);
    scanner.close();
  }
}
