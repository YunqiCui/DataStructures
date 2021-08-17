package com.cyunq.algorithms.prime;

public class Graph {

    public int countVertex;//表示图的节点个数
    public char[] data;//存放节点的数据
    public int[][] weight;//存放边的邻接矩阵

    public Graph(int countVertex){
        this.countVertex = countVertex;
        data = new char[countVertex];
        weight = new int[countVertex][countVertex];
    }

    public void setWeight(int[][] weight) {
        this.weight = weight;
    }

    public int[][] getWeight(){
        return weight;
    }
}
