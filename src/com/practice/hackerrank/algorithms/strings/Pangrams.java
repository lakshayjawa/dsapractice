package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * [Pangrams](https://www.hackerrank.com/challenges/pangrams/problem)
 *
 * @author lakshay
 */
public class Pangrams {
    // Complete the pangrams function below.
    static String pangrams(String s) {
        int[] letters = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                letters[ch - 'A'] = 1;
            }else if(Character.isLowerCase(ch)){
                letters[ch - 'a'] = 1;
            }
            // else skip it
        }
        int letterCount = 0;
        for(int letterOccurrence : letters){
            if(letterOccurrence == 1 ){
                letterCount++;
            }
        }
        if(letterCount == 26){
            return "pangram";
        }
        return "not pangram";
    }

    static boolean isPangrams(String s) {
        for (int i = 97; i <= 122; i++) {
            char ch = (char) i;
            // here index of method will go over the string multiple times
            // resulting in O(n^2) whereas the above method will do it in O(n)
            if (s.indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();
        String result = pangrams(s);
        System.out.println(result);
        scanner.close();
    }

}
