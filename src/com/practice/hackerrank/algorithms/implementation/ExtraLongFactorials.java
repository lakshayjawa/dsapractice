package com.practice.hackerrank.algorithms.implementation;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * [Extra Long Factorials] (https://www.hackerrank.com/challenges/extra-long-factorials/problem)
 *
 * @author lakshay
 */
public class ExtraLongFactorials {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger fact =BigInteger.ONE;
        for(int i =1; i<= n; i++){
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        System.out.println(fact);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
