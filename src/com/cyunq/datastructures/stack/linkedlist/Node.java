package com.cyunq.datastructures.stack.linkedlist;
public class Node{
    private int no;//节点编号
    private int value;//节点的数据
    private Node next;//节点的指针

    //构造器
    public Node(int no,int value){
        this.no = no;
        this.value = value;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", value=" + value +
                '}';
    }
}

