package com.practice.hackerrank.algorithms.implementation;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * [Cavity Map]
 * (https://www.hackerrank.com/challenges/cavity-map/problem)
 *
 * @author lakshay
 */

public class CavityMap {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        char[][] cg = new char[grid.length][];
        for (int i =0; i<grid.length;i++){
            cg[i] = grid[i].toCharArray();
        }

        for (int i =1; i<grid.length -1;i++){
            for(int j =1; j< cg[i].length-1;j++){
                if(cg[i][j+1] == 'X' ||
                        cg[i][j-1] == 'X' ||
                        cg[i+1][j] == 'X' ||
                        cg[i-1][j] == 'X'
                ){
                    continue;
                }
                if( cg[i][j] > cg[i-1][j]
                        &&  cg[i][j] > cg[i][j+1]
                        && cg[i][j] > cg[i][j-1]
                        && cg[i][j] > cg[i+1][j]
                ){
                    cg[i][j] = 'X';
                }
            }
        }

        for (int i =0; i<grid.length;i++){
            grid[i] = String.valueOf(cg[i]);
        }
        return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

