package com.practice.hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Todo
 *
 * @author lakshay
 */
public class TwoCharacters {
    // Complete the alternate function below.
    static int alternate(String s) {
        Integer[] frequency = new Integer[26];
        Map<Character,Integer> m = new HashMap<>();
        for(int i=0;i<26;i++){
            m.put((char)(i+26),0);
        }
        for(int i=0;i<s.length();i++){
            //frequency[s.charAt(i)-'a']++;
            Character ch = s.charAt(i);
            m.put(ch, m.get(ch)+1);
        }
        m.entrySet().stream().sorted();

        //Arrays.sort();
        Arrays.sort(frequency, (s1,s2)-> s2.compareTo(s1));
        // TODO pending work
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(bufferedReader.readLine().trim());
        String s = bufferedReader.readLine();
        int result = alternate(s);
        System.out.println(result);
        bufferedReader.close();
    }
}
