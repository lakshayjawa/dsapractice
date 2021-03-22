package com.practice.hackerrank.datastructures.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * [Maximum element] (https://www.hackerrank.com/challenges/maximum-element/problem)
 *
 * Class structures have been modified as per need
 * @author lakshay
 */
public class MaximumElement {

  static class Result {
    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
      // Write your code here
      List<Integer> result = new ArrayList<>();
      Stack<Node> st = new Stack<>();
      for (String op : operations) {
        String[] opAndElement = op.split(" ");
        if (opAndElement[0].equals("1")) {
          // push the element
          int data = Integer.parseInt(opAndElement[1]);
          if (st.size() > 0) {
            st.push(new Node(data, Math.max(st.peek().getMax(), data)));
          } else {
            st.push(new Node(data, data));
          }

        } else if (opAndElement[0].equals("2")) {
          st.pop();
        } else if (opAndElement[0].equals("3")) {
          if(st.size() >0 ){
            result.add(st.peek().getMax());
          }
        }
      }
      return result;
    }

    private static Integer maxElement(Stack<Integer> stack) {
      int max = 0;
      for (Integer i : stack) {
        max = Math.max(i, max);
      }
      return max;
    }

    static class Node {
      int data;
      int max;

      Node(int data, int max) {
        this.data = data;
        this.max = max;
      }

      public int getData() {
        return data;
      }

      public int getMax() {
        return max;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine().trim());
    List<String> ops =
        IntStream.range(0, n)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine();
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .collect(toList());

    List<Integer> res = Result.getMax(ops);
    System.out.print(res.stream().map(Object::toString).collect(joining("\n")) + "\n");
    bufferedReader.close();
  }
}
