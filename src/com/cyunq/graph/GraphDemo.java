package com.cyunq.graph;

public class GraphDemo {
    public static void main(String[] args) {

        String[] vertexValue = {"A","B","C","D","E"};
        testGraph1(vertexValue);

        String[] vertexValue1 = {"1","2","3","4","5","6","7","8"};
        testGraph2(vertexValue1);
    }

    private static void addVertex(Graph graph, String[] vertexValue){
        //添加顶点
        for (String value : vertexValue){
            graph.insertVertex(value);
        }
    }

    private static void testGraph1(String[] vertexValue){

        Graph graph = new Graph(vertexValue.length);
        addVertex(graph,vertexValue);

        //添加边
        //A-B, A-C, B-C, B-D, B-E
        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);

        graph.showGraph();
        System.out.println("深度优先遍历");
        graph.dfs();

        System.out.println();
        System.out.println();
        System.out.println("广度优先遍历");
        graph.bfs();
    }

    /**
     * 测试深度与广度优先的具体区别
     * @param vertexValue 顶点数组
     */
    private static void testGraph2(String[] vertexValue){
        Graph graph = new Graph(vertexValue.length);
        addVertex(graph,vertexValue);

        //添加边
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);
        graph.insertEdges(3, 7, 1);
        graph.insertEdges(4, 7, 1);
        graph.insertEdges(2, 5, 1);
        graph.insertEdges(2, 6, 1);
        graph.insertEdges(5, 6, 1);

        graph.showGraph();
        System.out.println("深度优先遍历");
        graph.dfs();
        System.out.println();
        System.out.println();
        System.out.println("广度优先遍历");
        graph.bfs();
    }
}
