package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Problem
 * [LoveLetterMystery](https://www.hackerrank.com/challenges/the-love-letter-mystery/problem)
 *
 * @author lakshay
 */
public class LoveLetterMystery {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        char[] ch = s.toCharArray();
        int numberOfChanges = 0;
        for(int i=0;i<ch.length / 2 ;i++){
            numberOfChanges += Math.abs(ch[i] - ch[ch.length - 1 - i]);
        }
        return numberOfChanges;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            System.out.println(result);
        }


        scanner.close();
    }
}
