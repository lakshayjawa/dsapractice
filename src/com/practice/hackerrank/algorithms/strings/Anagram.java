package com.practice.hackerrank.algorithms.strings;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problem statement [Anagram] (https://www.hackerrank.com/challenges/anagram/problem)
 *
 * <p>Two strings are anagrams of each other if the first string's letters can be rearranged to form
 * the second string. In other words, both strings must contain the same exact letters in the same
 * exact frequency.
 *
 * @author lakshay
 */
public class Anagram {

  // Complete the anagram function below.
  static int anagram(String s) {

    if (s.length() % 2 != 0) {
      return -1;
    }
    int numberOfDifferentChars = 0;
    char[] ch = s.toCharArray();
    int[] frequency = new int[26];
    for (int i = 0; i < ch.length; i++) {
      int letterIndex = ch[i] - 'a';
      if (i < ch.length / 2) {
        // if a letter exists in first half increase its frequency/occurrence
        frequency[letterIndex]++;
      } else {
        // if a letter exists in latter half decrease its frequency/occurrence
        frequency[letterIndex]--;
      }
    }

    for (int i = 0; i < 26; i++) {
      // System.out.print(frequency[i]);
      if (frequency[i] > 0) {
        // we are only checking for
        numberOfDifferentChars += frequency[i];
      }
    }
    return numberOfDifferentChars;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = anagram(s);
      System.out.println(result);
    }

    scanner.close();
  }
}
