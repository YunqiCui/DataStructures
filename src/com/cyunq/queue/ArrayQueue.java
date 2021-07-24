package com.cyunq.queue;

public class ArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队列最后一个位置
    }

    //check if Queue is full
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //check if Queue is empty
    public boolean isEmpty() {
        return rear == front;
    }

    //add value into Queue
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //get value from Queue

    public int getQueue() {
        if (isEmpty()) {
            //throw exception
            throw new RuntimeException("Queue is empty.");
        }
        front++;
        return arr[front];
    }

    //show all queue
    public void showList() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //show fisrt queue element
    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return arr[front + 1];
    }
}
