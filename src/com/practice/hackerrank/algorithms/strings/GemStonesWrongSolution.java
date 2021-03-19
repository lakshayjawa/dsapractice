package com.practice.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Problem
 * [GemStones](https://www.hackerrank.com/challenges/gem-stones/problem)
 *
 * This solution doesn't take care of duplicates within gems within the same rock
 *
 * @author lakshay
 */
public class GemStonesWrongSolution {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        int numOfGemsResult =0;
        int numOfRocks = arr.length;
        // ascii array of gems
        int[] gems = new int[26];
        markAvailable(arr[0],gems, true);
        for(int i=1;i<arr.length;i++){
            markAvailable(arr[i],gems, false);
        }

        for(int gemCount : gems){
            System.out.print(gemCount);
            if(gemCount > 0 && (gemCount) % numOfRocks ==0){
                numOfGemsResult++;
            }
        }

        return numOfGemsResult;

    }

    static void markAvailable(String rock,int[] gems,boolean isFirstRock){
        for(int i=0;i<rock.length();i++){
            int gemIndex = rock.charAt(i) - 'a';
            if(isFirstRock){
                // mark if first Rock
                gems[gemIndex] =1;
            }else if(gems[gemIndex] >= 1){
                // mark if already present in other rocks
                gems[gemIndex]++;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }
        int result = gemstones(arr);
        System.out.println(result);

        scanner.close();
    }
}
