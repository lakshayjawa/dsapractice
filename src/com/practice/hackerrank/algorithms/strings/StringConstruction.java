package com.practice.hackerrank.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem
 * [String Construction](https://www.hackerrank.com/challenges/string-construction/problem)
 *
 * @author lakshay
 */
public class StringConstruction {
    // Complete the stringConstruction function below.
    static int stringConstruction(String s) {
        int[] letters = new int[26];
        for(int i=0;i < s.length();i++){
            letters[s.charAt(i) - 'a']++;
        }
        int result=0;
        for(int i: letters){
            if(i>0){
                result++;
            }
        }
        return result;
    }

    // Complete the stringConstruction function below.
    static int stringConstructionUsingSet(String s) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i < s.length();i++){
            set.add(s.charAt(i));
        }
        return set.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = stringConstruction(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
