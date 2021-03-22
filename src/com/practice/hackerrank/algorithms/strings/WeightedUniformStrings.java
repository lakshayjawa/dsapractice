package com.practice.hackerrank.algorithms.strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [Weighted Uniform Strings]
 * (https://www.hackerrank.com/challenges/weighted-uniform-string/problem)
 * @author lakshay
 */
public class WeightedUniformStrings {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        Set<Integer> set = new HashSet<>();
        int len = s.length();
        char[] ch = s.toCharArray();
        for(int i=0;i<s.length();i++){
            char temp = ch[i];
            int count = 1;
            set.add(s.charAt(i)-'a'+1);
            for(int j=i+1;j<s.length();j++){
                if(ch[i] == ch[j]){
                    count++;
                    set.add(count * (s.charAt(j)-'a'+1));
                    i=j;
                }else{
                    break;
                }
            }
        }

        String[] result  = new String[queries.length];
        for(int i=0;i<queries.length;i++){
            if(set.contains(queries[i])){
                result[i] = "Yes";
            }else{
                result[i] = "No";
            }
        }
        return result;
    }


    /*
     Complete the weightedUniformStrings function below.
     The below code is failing due to timeout.
     Since in the below approach the HashMap keys are not being used, so switched it to hashset
     */
    static String[] weightedUniformStringsUnOptimized(String s, int[] queries) {
        Map<String,Integer> map = new HashMap<>();
        int len = s.length();
        char[] ch = s.toCharArray();
        for(int i=0;i<s.length();i++){
            // be careful with string builder
            // new StringBuilder(ch[i]); will initialize it with capacity
            StringBuilder key = new StringBuilder();
            key.append(ch[i]);
            map.put(key.toString(),s.charAt(i)-'a'+1);
            for(int j=i+1;j<s.length();j++){
                if(ch[i] == ch[j]){
                    int previous = map.get(key.toString());
                    key.append(ch[j]);
                    map.put(key.toString(),previous+s.charAt(j)-'a'+1);
                    i=j;
                }else{
                    break;
                }
            }
        }

//        map.forEach((s1,i)-> System.out.println("S = "+s1+" I = " + i));
        Set<Integer> weights = new HashSet<>(map.values());
        String[] result  = new String[queries.length];
        for(int i=0;i<queries.length;i++){
            if(weights.contains(queries[i])){
                result[i] = "Yes";
            }else{
                result[i] = "No";
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        scanner.close();
    }
}
