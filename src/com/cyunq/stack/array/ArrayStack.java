package com.cyunq.stack.array;

public class ArrayStack{

    private int maxSize;//stack size
    private int[] stack;//数组模拟栈
    private int top = -1;//top表示栈顶，初始化为-1

    /**
     * Constructor of class ArrayStack
     *
     * @param maxSize size of stack
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * @return true when stack is full
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * @return true when stack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     *
     * @param value number adding into stack
     */
    public void push(int value) {
        //判断栈是否满
        if (isFull()) {
            System.out.println("Stack is Full!");
        }
        top++;
        stack[top] = value;
    }

    /**
     * get value from stack
     * @return pop value from stack
     */
    public int pop() {
        //先判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * traverse stack - from top item
     */
    public void list(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }

    public int peek(){
        return stack[top];
    }
}
