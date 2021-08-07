package com.cyunq.datastructures.stack.array;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        //创建一个ArrayStack
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;

        Scanner sc = new Scanner(System.in);

        while (loop) {
            System.out.println("show : Show Stack.");
            System.out.println("exit : Exit system.");
            System.out.println("push : add into Stack");
            System.out.println("pop : get from Stack");

            key = sc.next();

            switch (key) {
                //show the full list of the stack
                case "show":
                    try {
                        stack.list();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                //close system
                case "exit":
                    System.out.println("See you next time!");
                    sc.close();
                    loop = false;
                    break;
                //add item in stack.
                case "push":
                    System.out.println("Please enter a number: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                //take out item from stack
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("Item been taken out is %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
