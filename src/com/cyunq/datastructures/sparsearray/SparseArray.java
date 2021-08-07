package com.cyunq.datastructures.sparsearray;
import java.io.*;

//Sparse Array Data Structure code implementation

import java.io.FileWriter;

public class SparseArray {

    public static void main (String args[]) throws IOException {
        //Create Array
        //0: no 1: black 2:blue

        int chessArr1 [][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[5][6] = 2;
        //display original array
        for (int [] row : chessArr1){
            for (int data : row){
                System.out.print("\t" + data);
            }
            System.out.println();
        }

        //Go through original array
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("Sum = " + sum);

        //Create Sparse Array
        int sparseArray [][] = new int[sum+1][3];

        //Assign value to sparse array
        sparseArray [0][0] = chessArr1.length;
        sparseArray [0][1] = chessArr1.length;
        sparseArray [0][2] = sum;


        // create sparse array
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                  sparseArray [count][0] = i;
                  sparseArray [count][1] = j;
                  sparseArray [count][2] = chessArr1[i][j];

                }
            }
        }

        //save parse array into file

        FileWriter fw = new FileWriter("data.txt");

        //print parse array
        System.out.println();
        System.out.println("Parse Array~~~~~~~~~");
        for (int i = 0; i < sparseArray.length; i++) {
            fw.write(sparseArray[i][0] + "\t" + sparseArray[i][1] + "\t" + sparseArray[i][2] + "\n");
        }
        fw.close();
        //TODO Read Parse Array back from data file.
        //Read Data File
//        Scanner scanner = new Scanner("data.txt");
//        int [][]resumeParse = new int[4][3];
//
//        while (scanner.hasNextLine()){
//            for (int i = 0; i < resumeParse.length; i++) {
//                String []s = scanner.nextLine().split("  ");
//                for (int j = 0; j < s.length; j++) {
//                    resumeParse[i][j] = Integer.parseInt(s[j]);
//                }
//            }
//        }

        //resume original Array
        //1. get orginal array data.
        int chessArr2 [][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        System.out.println();
        System.out.println("Original Array");
        //assign value to original array
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }


        //print original array
        for (int [] row : chessArr2){
            for (int data : row){
                System.out.print("\t" + data);
            }
            System.out.println();
        }

    }
}
