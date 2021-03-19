package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Problem Statement [Making Anagrams]
 * (https://www.hackerrank.com/challenges/ctci-making-anagrams/problem)
 *
 * <p>Two strings are anagrams of each other if the first string's letters can be rearranged to form
 * the second string. In other words, both strings must contain the same exact letters in the same
 * exact frequency.
 *
 * @author lakshay
 */
public class MakingAnagrams {

  // Complete the makeAnagram function below.
  static int makeAnagram(String a, String b) {
    int aLen = a.length();
    int bLen = b.length();
    int maxLen = Math.max(aLen, bLen);
    int[] occurrences = new int[26];
    int result = 0;
    for (int i = 0; i < maxLen; i++) {
      if (i < aLen) {
        int letter = a.charAt(i) - 'a';
        occurrences[letter]++;
      }
      if (i < bLen) {
        int letter = b.charAt(i) - 'a';
        occurrences[letter]--;
      }
    }

    for (int i = 0; i < 26; i++) {
      if (occurrences[i] < 0) {
        result -= occurrences[i];
      } else {
        result += occurrences[i];
      }
    }
    return result;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String a = scanner.nextLine();
    String b = scanner.nextLine();
    int res = makeAnagram(a, b);
    System.out.println(res);
    scanner.close();
  }
}
