package com.cyunq.algorithms.prime;

import java.util.Arrays;

public class MinTree {

    /**
     *
     * @param graph 图对象
     * @param countVertex 图的顶点个数
     * @param data 图的顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(Graph graph, int countVertex, char[] data,int[][] weight){
        int i, j;

        for (i = 0; i < countVertex; i++) {//遍历顶点
            graph.data[i] = data[i];
            for (j = 0; j < countVertex; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(Graph graph){
        for (int[] edges : graph.weight) {
            System.out.println(Arrays.toString(edges));
        }
    }

    /**
     * 普里姆算法
     *
     * @param g 生成最小生成树的图
     * @param v 起始顶点
     */
    public void primeAl(Graph g, int v) {

        int[][] newWeight = new int[g.countVertex][g.countVertex];
        //标记节点是否被访问过
        int[] visited = new int[g.countVertex];
        visited[v] = 1;
        //记录路径最短的两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;//将最小权值初始成一个大数

        for (int k = 1; k < g.countVertex; k++) {//

            //判断每一个生成的子图，和哪个节点的距离最近
            for (int i = 0; i < g.countVertex; i++) {//遍历所有访问过的节点
                for (int j = 0; j < g.countVertex; j++) {//遍历所有没有访问过的节点
                    if (visited[i] == 1 && visited[j] !=1 &&g.weight[i][j] < minWeight){
                        minWeight = g.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            /*g.weight[h1][h2] = 1;
            g.weight[h2][h1] = 1;*/
            newWeight[h1][h2] = minWeight;
            newWeight[h2][h1] = minWeight;
            System.out.println("边<"+g.data[h1]+","+g.data[h2]+">, 权值： "+minWeight);
            visited[h2] = 1;
            //重置minweight
            minWeight = 10000;
        }
        for (int[] weight : newWeight){
            for (int i = 0; i < weight.length; i++) {
                if (weight[i] == 0){
                    weight[i] = 10000;
                }
            }
        }
        g.setWeight(newWeight);
    }
}
