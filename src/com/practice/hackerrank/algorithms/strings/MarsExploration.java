package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Problem
 * [Mars Exploration](https://www.hackerrank.com/challenges/mars-exploration/problem)
 *
 * @author lakshay
 */
public class MarsExploration {
    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        char[] sos = {'S','O','S'};
        int result = 0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i) != sos[i%3]){
                result++;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        String s = scanner.nextLine();
        int result = marsExploration(s);
        System.out.println(result);
        scanner.close();
    }
}
