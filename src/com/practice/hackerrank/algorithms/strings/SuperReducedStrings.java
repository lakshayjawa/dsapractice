package com.practice.hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 *  Problem Statement:
 *  [Super Reduced String] - (https://www.hackerrank.com/challenges/reduced-string/problem)
 *
 * @author lakshay
 */
public class SuperReducedStrings {
    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (char c : ch) {
            if (st.isEmpty()) {
                st.push(c);
            } else if (st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        if (st.isEmpty()) {
            return "Empty String";
        } else {
            while (!st.isEmpty()) {
                result.insert(0, st.pop());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();

        String result = superReducedString(s);
        System.out.println(result);
        bufferedReader.close();
    }
}
