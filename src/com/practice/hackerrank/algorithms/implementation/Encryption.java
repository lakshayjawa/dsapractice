package com.practice.hackerrank.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * [Encryption] (https://www.hackerrank.com/challenges/encryption/problem)
 *
 * @author lakshay
 */
public class Encryption {

  // Complete the encryption function below.
  static String encryptionFirstTry(String s) {
    String withoutSpace = s.replace(" ", "");
    double len = Math.sqrt(withoutSpace.length());
    int row = (int) Math.floor(len);
    int col = (int) Math.ceil(len);
    if (row * col < withoutSpace.length()) {
      row++;
    }
    char[][] arr = new char[row][col];
    StringBuilder builder = new StringBuilder();
    int x = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (x < withoutSpace.length()) {
          arr[i][j] = withoutSpace.charAt(x);
          x++;
        }
      }
    }

    for (int j = 0; j < col; j++) {
      for (int i = 0; i < row; i++) {
        if (Character.isAlphabetic(arr[i][j])) {
          builder.append(arr[i][j]);
        }
      }
      builder.append(" ");
    }

    return builder.toString().trim();
  }

  /**
   * Shorter code than above
   *
   * @param s string to encrypt
   * @return encrypted string
   */
  static String encryption(String s) {
    int length = s.length();
    double rows = Math.floor(Math.sqrt(length));
    double cols = Math.ceil(Math.sqrt(length));
    int len = (int) (Math.max(rows, cols));
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < len; i++) {
      for (int j = i; j < s.length(); j = (int) (j + cols)) {
        char ch = s.charAt(j);
        result.append(ch);
      }
      result.append(" ");
    }
    return result.toString();
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scanner.nextLine();

    String result = encryption(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
