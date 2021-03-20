package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Problem
 * [Strong Password] - (https://www.hackerrank.com/challenges/strong-password/problem)
 *
 * @author lakshay
 */
public class StrongPassword {
    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int requiredLength = 6;
        if(n == 0)
            return requiredLength;
        boolean hasOneDigit = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasSpecialChars = false;

        for(int i=0;i<password.length();i++) {
            char c = password.charAt(i);
            hasUpperCase = Character.isUpperCase(c)|| hasUpperCase;
            hasLowerCase = Character.isLowerCase(c)|| hasLowerCase;
            hasOneDigit = Character.isDigit(c) || hasOneDigit;
            hasSpecialChars = "!@#$%^&*()-+".contains(String.valueOf(c))|| hasSpecialChars;
        }
        int result = 0;
        if(!hasUpperCase) result++;
        if(!hasLowerCase) result++;
        if(!hasOneDigit) result++;
        if(!hasSpecialChars) result++;

        return Math.max(result, requiredLength - n);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String password = scanner.nextLine();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        scanner.close();
    }
}
