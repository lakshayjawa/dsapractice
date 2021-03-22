package com.practice.hackerrank.datastructures.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/**
 * [Array Left Rotation] (https://www.hackerrank.com/challenges/array-left-rotation/problem)
 *
 * @author lakshay
 */
public class ArrayLeftRotation {

  static class Result {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
      // keep in Mind
      // Arraylist will not allow inserting the element at an index more than its size,
      // It will throw IndexOutOfBoundException. So we need to start with 0th index to insert in the array
      // Approach is to set the value at appropriate index in result starting from 0.
      List<Integer> result = new ArrayList<>(arr.size());
      d = d % arr.size();
      for (int i = d; i < arr.size() + d; i++) {
        if (i >= arr.size()) {
          result.add(arr.get(i % arr.size()));
        } else {
          result.add(arr.get(i));
        }
      }
      return result;
    }

    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

      String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      int n = Integer.parseInt(firstMultipleInput[0]);

      int d = Integer.parseInt(firstMultipleInput[1]);

      List<Integer> arr =
          Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
              .map(Integer::parseInt)
              .collect(toList());

      List<Integer> result = Result.rotateLeft(d, arr);

      System.out.println(result.stream().map(Object::toString).collect(joining(" ")));

      bufferedReader.close();
    }

    /**
     * I think this is the best solution because it just adds the value to the appropriate index and
     * then just prints it.
     *
     * @param args -args
     */
    public static void main2(String[] args) {
      // RHS rotation
      // d = 2 , d means rotation
      // n = 5 , n means size of array

      //  0 1 2 3 4 , array indices

      //  d = 2
      //  i  -> d , i is the iteration variable
      //  0 -> 2 i + d
      //  1 -> 3 i + d
      //  2 -> 4 i + d
      //  3 -> 0 ((i + d ) % n )
      //  4 -> 1 (i + d) % n
      // (i + d) % n   -- this would work for all values

      // For LHS Rotation
      // d = 1 , d means rotation
      // n = 5 , n means size of array

      // 0 1 2 3 4 , array indices

      //  d = 2
      //  i  -> d , i is the iteration variable
      //  2 -> 0 -> 2 - 2  = 0 (i - d)
      //  3 -> 1 -> 3 - 2  = 1 (i - d)
      //  4 -> 2 -> 4 - 2  = 2 (i - d)
      //  0 -> 3 -> 0 - 2 = -2 ==> - 2 can't be an index so we need to come to 3 by adding size => -2 + 5 => 3
      //  1 -> 4 -> 1 - 2 = -1 ==> - 1 can't be an index so we need to come to 4 by adding size => -1 + 5 => 4
      // (i -d + n ) for cases where  i - d < 0 and d < n
      // for all values of d we need to use (i -d + n ) % n  can be used to get the remainder
      // Remember: Using modulo operator Restrict Number to Range (size of array)

      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int d = scan.nextInt();
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[(i + n - d) % n] = scan.nextInt();
      }
      for (int i = 0; i < n; i++) {
        System.out.print(array[i] + " ");
      }
    }
  }
}
