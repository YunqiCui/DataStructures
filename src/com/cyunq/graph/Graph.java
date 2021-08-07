package com.cyunq.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//图的顶点
    private int[][] edges;//图的边
    private int numOfEdges;//表示边的数目
    private boolean[] isVisited;

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
     * 添加边
     *
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

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        System.out.println();
        System.out.println();
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
        System.out.println();
    }

    /**
     * 返回当前节点的下一个节点的下标
     *
     * @param index 当前节点在ArrayList中的下标
     * @return 返回下一个邻接节点的下标
     */
    public int getNext(int index) {

        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     *
     * @param v1 当前节点下标
     * @param v2 前一个邻接节点下标
     * @return 下一个邻接节点下标
     */
    public int getNextAfter(int v1, int v2) {

        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0 ){
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历算法
     */
    private void dfs(boolean[] isVisited, int i){
        //首先访问该节点
        System.out.print(getValueByIndex(i) + " -> ");
        isVisited[i] = true;

        int w = getNext(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextAfter(i, w);
        }
    }

    /**
     * @override 重载dfs算法
     */
    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    /**
     * 广度优先算法
     * @param isVisited
     * @param i
     */
    private void bfs(boolean[] isVisited, int i){
        int u;//表示队列头结点的下标
        int w;//表示邻接节点的下标
        //记录节点访问顺序的队列
        LinkedList<Integer> queue = new LinkedList<Integer>();
        //访问节点
        System.out.print(getValueByIndex(i) + " -> ");
        isVisited[i] = true;
        //将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()){
            //取出队列头结点下标
            u =  queue.removeFirst();
            //取出第一个邻接节点的下标
            w = getNext(u);
            while (w != -1){
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + " -> ");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextAfter(u,w);//提现广度优先的地方
            }
        }
    }

    /**
     * 遍历所有的节点，都进行广度优先
     */
    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }
}









































