package com.cyunq.treeadvance.huffmancoding;

public class HuffmanNode implements Comparable<HuffmanNode>{
    Byte data;
    int weight;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" + "data=" + data + ", weight=" + weight + '}';
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

    @Override
    public int compareTo(HuffmanNode o) {
        return this.weight - o.weight;
    }
}
