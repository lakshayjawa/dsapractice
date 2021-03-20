package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Problem [Game of Thrones](https://www.hackerrank.com/challenges/game-of-thrones/problem)
 *
 * <p>Given a string, determine if it can be rearranged into a palindrome. Return the string YES or
 * NO.
 *
 * <p>Check if a String is an anagram of a palindrome.
 *
 * @author lakshay
 */
public class GameOfThrones {
  // Complete the gameOfThrones function below.
  static String gameOfThrones(String s) {
    int[] letters = new int[26];
    // to check if the string is anagram of a palindrome

    for (int i = 0; i < s.length(); i++) {
      // check if the frequency of characters is even
      int letterIndex = s.charAt(i) - 'a';
      letters[letterIndex]++;
    }

    int countOddFrequency = 0;
    for (int i : letters) {
      if (i % 2 != 0) {
        countOddFrequency++;
      }
    }

    if (countOddFrequency == 0 || (s.length() % 2 != 0 && countOddFrequency == 1)) {
      // if string length is odd then one character with odd
      // frequency is allowed
      return "YES";
    }

    return "NO";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String s = scanner.nextLine();
    String result = gameOfThrones(s);
    System.out.println(result);
    scanner.close();
  }
}
