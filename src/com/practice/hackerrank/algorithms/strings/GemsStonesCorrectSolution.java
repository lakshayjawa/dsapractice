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
public class GemsStonesCorrectSolution {


    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        int numOfGemsResult = 0;
        int numOfRocks = arr.length;
        // ascii array of gems
        int[] gems = new int[26];
        for (int i = 0; i < arr.length; i++) {
            markAvailable(arr[i], gems, i + 1);
        }

        for (int gemCount : gems) {
            System.out.print(gemCount);
            if (gemCount > 0 && gemCount == numOfRocks) {
                numOfGemsResult++;
            }
        }

        return numOfGemsResult;
    }

    /**
     * Pay attention here, contrary to the previous programs, here we are marking the index of the row
     * as a decider for presence of an element in all strings. Here we are not simply incrementing the
     * count in the gems array as we need to avoid duplicates letters within the same rock string.
     * <br>
     * <br>
     * Nice Technique learnt as an alternative to handle duplicates in {@code GemStonesWrongSolution}
     *
     * @param rock - rockString
     * @param gems - gemsArray
     * @param rockNum - rockNumber
     */
    static void markAvailable(String rock, int[] gems, int rockNum) {
        for (int i = 0; i < rock.length(); i++) {
            int gemIndex = rock.charAt(i) - 'a';
            if (rockNum == 1) {
                // mark if first Rock
                gems[gemIndex] = 1;
            } else if (gems[gemIndex] == rockNum - 1) {
                // mark if already present in other rocks
                gems[gemIndex] = rockNum;
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
