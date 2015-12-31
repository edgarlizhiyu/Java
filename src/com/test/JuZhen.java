package com.test;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/17.
 *  二位数组接收  1,2,3
 4,5,6
 a[2][3]
 目标数组         1，4
 2，5
 3，6
 b[3][2]

 */


public class JuZhen {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int i = 0;
        int j = 0;
        int x = 0;
        int number = 0;
        System.out.println("请先择矩阵的行数：");
        i = input.nextInt();
        System.out.println("请先择矩阵的列数：");
        j =  input.nextInt();
        int [][] arrayA = new int[i][j];
        int [][] arrayB = new int[j][i];
        int [][] arrayC = new int[i][i];
        for( i = 0;i < arrayA.length;i++){
            for ( j = 0; j < arrayA[i].length;j++){
                System.out.println("请输入1个数");
                arrayA[i][j]= input.nextInt();
                arrayB[j][i]=arrayA[i][j];
            }
        }
        for( i = 0;i < arrayA.length;i++){
            for(j = 0; j < arrayB[i].length; j++){
                for( x=0;x<arrayA[j].length;x++){
                    number += arrayA[i][x] * arrayB[x][j];
                }
                arrayC[i][j]=number;
                number = 0;
            }
        }
        //A
        System.out.println("输出A矩阵：");
        for(i = 0 ; i < arrayA.length;i++){
            for(j = 0; j< arrayA[i].length;j++){
                System.out.print(arrayA[i][j]+"\t"+"\t");
            }
            System.out.println();
        }
        //B
        System.out.println("输出B矩阵：");
        for(i = 0 ; i < arrayB.length;i++){
            for(j = 0; j< arrayB[i].length;j++){
                System.out.print(arrayB[i][j]+"\t"+"\t");
            }
            System.out.println();
        }

        //C=A*B
        System.out.println("输出C矩阵：");
        for( i = 0;i < arrayC.length;i++){
            for ( j = 0; j < arrayC[i].length;j++){
                System.out.print(arrayC[i][j]+"\t"+"\t");
            }
            System.out.println();
        }
    }
}

