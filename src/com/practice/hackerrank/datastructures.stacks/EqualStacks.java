package com.practice.hackerrank.datastructures.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * [Equal Stacks]
 * (https://www.hackerrank.com/challenges/equal-stacks/problem)
 * @author lakshay
 */
public class EqualStacks {

  static class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
      // Write your code here
      Stack<Node> s1 = new Stack<>();
      Stack<Node> s2 = new Stack<>();
      Stack<Node> s3 = new Stack<>();
      pushToStack(h1, s1);
      pushToStack(h2, s2);
      pushToStack(h3, s3);
      int equalHeight = 0;
      while (s1.size() > 0 && s2.size() > 0 && s3.size() > 0) {

        int s1Hyt = s1.peek().getTotalHeight();
        int s2Hyt = s2.peek().getTotalHeight();
        int s3Hyt = s3.peek().getTotalHeight();
        if (s1Hyt == s2Hyt && s2Hyt == s3Hyt) {
          equalHeight = s1Hyt;
          break;
        }

        int smallestHyt = Math.min(Math.min(s1Hyt, s2Hyt), s3Hyt);
        System.out.println("smH = " + smallestHyt);
        if (smallestHyt < s1Hyt) {
          s1.pop();
        }
        if (smallestHyt < s2Hyt) {
          s2.pop();
        }
        if (smallestHyt < s3Hyt) {
          s3.pop();
        }
      }
      return equalHeight;
    }

    private static void pushToStack(List<Integer> h, Stack<Node> s) {
      for (int i = h.size() - 1; i >= 0; i--) {
        if (s.size() == 0) {
          s.push(new Node(h.get(i)));
        } else {
          s.push(new Node(h.get(i) + s.peek().getTotalHeight()));
        }
      }
    }

    static class Node {
      int totalHeight;

      Node(Integer i) {
        this.totalHeight = i;
      }

      public int getTotalHeight() {
        return totalHeight;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n1 = Integer.parseInt(firstMultipleInput[0]);

    int n2 = Integer.parseInt(firstMultipleInput[1]);

    int n3 = Integer.parseInt(firstMultipleInput[2]);

    List<Integer> h1 =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> h2 =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> h3 =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.equalStacks(h1, h2, h3);

    System.out.println(result);

    bufferedReader.close();
  }
}
