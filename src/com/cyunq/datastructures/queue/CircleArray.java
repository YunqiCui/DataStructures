package com.cyunq.datastructures.queue;

public class CircleArray {
    private int maxSize;//indicate the max size of the array
    private int front;//indicate first element of queue
    private int rear;//indicate one place after last element of queue
    private int[] arr;//Array as queue

    public CircleArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //check if queue is full.
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //check if Queue is empty
    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        //add element
        arr[rear] = n;
        rear = (rear + 1) % maxSize;//这里必须考虑取模

    }

    public int getQueue() {
        if (isEmpty()) {
            //throw exception
            throw new RuntimeException("Queue is empty.");
        }
        //front is point to the first element of queue
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移,考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showList() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        }
        //思路：从front开始遍历，遍历
        for (int i = front; i < front+ size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求队列的有效数据值
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return arr[front];
    }

}
