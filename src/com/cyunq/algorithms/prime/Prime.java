package com.cyunq.algorithms.prime;

import java.util.Arrays;

public class Prime {
    public static void main(String[] args) {

        //测试图是否创建成功
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        Graph graph = new Graph(data.length);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, data.length, data, weight);
        minTree.showGraph(graph);
        minTree.primeAl(graph,1);
        minTree.showGraph(graph);
    }
}
