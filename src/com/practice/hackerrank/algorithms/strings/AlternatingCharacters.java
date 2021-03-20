package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Problem
 * Alternating Characters
 * https://www.hackerrank.com/challenges/alternating-characters/problem
 *
 * @author lakshay
 */
public class AlternatingCharacters {
    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        char previous = s.charAt(0);
        int result =0;
        for(int i=1; i<s.length(); i++){
            char current = s.charAt(i);
            if(previous == current){
                // delete
                result++;
            }else{
                previous = current;
            }
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
        scanner.close();
    }
}
