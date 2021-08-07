package com.cyunq.datastructures.treeadvance.huffmantree;

/**
 * 实现Comparable 接口 达成排序的作用
 */
public class Node implements Comparable<Node> {
    public int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大排序
        return this.value - o.value;
    }

    public void preOrder(){
        System.out.println(this);

        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
}
