package com.cyunq.stack.linkedlist;

public class LinkedListStack {
    private int top = -1;//栈顶指针
    private Node head = new Node(-1, 0);//头指针

    //构造器
    public LinkedListStack() {

    }

    //判断为空
    public boolean isEmpty() {
        return top == -1;
    }

    //删除数据，在头部删除
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = head.getNext().getValue();
        head.setNext(head.getNext().getNext());
        top--;
        return value;
    }

    //添加数据，头插法
    public void push(int value) {
        Node temp = head;

        top++;
        Node node = new Node(top, value);
        if (head.getNext() == null) {
            head.setNext(node);//插入第一个数据
        } else {
            node.setNext(head.getNext());
            head.setNext(node);//插入之后的数据
        }
    }

    //遍历
    public void show() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        Node temp = head.getNext();
        while (true){
            System.out.println(temp);
            if (temp.getNext() ==null){
                break;
            }
            temp = temp.getNext();
        }
    }
}