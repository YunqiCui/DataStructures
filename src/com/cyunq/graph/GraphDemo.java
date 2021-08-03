package com.cyunq.graph;

public class GraphDemo {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        String vertexValue[] = {"A","B","C","D","E"};

        //添加顶点
        for (String value : vertexValue){
            graph.insertVertex(value);
        }

        //添加边
        //A-B, A-C, B-C, B-D, B-E
        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);

        graph.showGraph();
    }
}
