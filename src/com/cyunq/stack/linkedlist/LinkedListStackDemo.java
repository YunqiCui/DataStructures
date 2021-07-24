package com.cyunq.stack.linkedlist;

import java.util.Scanner;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        //测试
        LinkedListStack listStack = new LinkedListStack();

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String key = "";
        while (loop) {
            System.out.println("输入show展示栈");
            System.out.println("输入exit退出程序");
            System.out.println("输入pop取出数据");
            System.out.println("输入push添加数据");
            System.out.println("请输入");
            key = scanner.next();
            switch (key) {
                case "show":
                    listStack.show();
                    break;
                case "pop":
                    try {
                        int pop = listStack.pop();
                        System.out.printf("取出的数据为%d\n", pop);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.println("请输入要添加的数据");
                    int value = scanner.nextInt();
                    listStack.push(value);
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序结束");


    }

}