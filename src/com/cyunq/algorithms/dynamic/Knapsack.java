package com.cyunq.algorithms.dynamic;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000};//物品的价值
        int m = 4;//表示背包的容量
        int n = val.length;//物品的个数
        //创建二维数组,v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值。
        int[][] v = new int[n + 1][m + 1];

        //定义一个二维数组，记录商品放入的情况
        int[][] path = new int[n + 1][m + 1];

        //初始化第一行和第一列，在本程序中，可以不处理

        /*Arrays.fill(v[0], 0); 等同于下面的代码,将第一行设置为0*/
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }
        /*将第一列设置为0*/
        for (int j = 0; j < v.length; j++) {
            v[j][0] = 0;
        }

        for (int i = 1; i < v.length ; i++) {//不处理第一行,i=1
            for (int j = 1; j < v[0].length ; j++) {//不处理第一列,j=1
                if (w[i-1] >j){ //因为我们的程序i 是从1 开始的，因此原来公式中w的i 应该修改成i-1
                    v[i][j] = v[i - 1][j];
                }else {
                    //公式需要一定的调整
                    /*v[i][j] = Math.max(v[i - 1][j], val[i-1] + v[i - 1][j - w[i-1]]);*/
                    //为了记录商品存放的情况，不能直接使用上面的公式了,需要if - else 来处理
                    if (v[i - 1][j] < val[i-1] + v[i - 1][j - w[i-1]]){
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //把当前的情况记录到path
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        for (int[] ints : v) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        //输出最后我们放入的是哪些商品
        //这样输出会有冗余的数据，其实只需要最后放入的数据
        /*for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                if (path[i][j] == 1 ){
                    System.out.printf("第%d放入背包中\n",i);
                }
            }
        }*/

        int i = path.length - 1;//行的下标最大值
        int j = path[0].length-1;//列的最大下标
        while (i >0 && j>0){
            if (path[i][j] == 1){
                System.out.printf("第%d商品放入背包中\n",i);
                j -= w[i - 1];
            }
            i--;
        }
    }
}
