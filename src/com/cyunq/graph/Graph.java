package com.cyunq.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList;//图的顶点
    private int[][] edges;//图的边
    private int numOfEdges;//表示边的数目

    public Graph(int n) {
        //初始化矩阵和vertexList

        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    public ArrayList<String> getVertexList() {
        return vertexList;
    }

    public void setVertexList(ArrayList<String> vertexList) {
        this.vertexList = vertexList;
    }

    public int[][] getEdges() {
        return edges;
    }

    public void setEdges(int[][] edges) {
        this.edges = edges;
    }



    public void setNumOfEdges(int numOfEdges) {
        this.numOfEdges = numOfEdges;
    }

    /**
     * 添加节点
     *
     * @param vertex 顶点
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * @param v1     顶点一的下标
     * @param v2     顶点二的下标
     * @param weight 默认为0，v1 与 v2 有链接时为1
     */
    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //图的常用方法

    /**
     * 得到当前顶点的个数
     *
     * @return int 顶点的个数
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }
}









































