package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Problem
 * [Two Strings]
 * (https://www.hackerrank.com/challenges/two-strings/problem)
 *
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 *
 * @author lakshay
 */
public class TwoStrings {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int[] letters = new int[26];
        for(int i=0;i<s1.length();i++){
            // exists in s1
            letters[s1.charAt(i) - 'a'] = 1;
        }

        for(int i=0;i<s2.length();i++){

            if(letters[s2.charAt(i) - 'a'] == 1){
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
        scanner.close();
    }
}
