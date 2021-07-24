package com.cyunq.queue;

import java.util.Scanner;

public class CircleArrayDemo {
    public static void main(String[] args) {
        CircleArray arr = new CircleArray(4);//MaxSize will be 3

        char key = ' ';
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show) : Show queue list.");
            System.out.println("e(exit) : Exit system.");
            System.out.println("a(add) : add into Queue");
            System.out.println("g(get) : get from Queue");
            System.out.println("h(head) : check the head item");

            key = sc.next().charAt(0);

            switch (key) {
                //show the full list of the queue
                case 's':
                    arr.showList();
                    break;
                //close system
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                //add item in queue.
                case 'a':
                    System.out.println("Please enter a number");
                    int value = sc.nextInt();
                    arr.addQueue(value);
                    break;
                //take out first item from queue
                case 'g':
                    try {
                        int res = arr.getQueue();
                        System.out.printf("Item been taken out is %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                //show first item in the queue.
                case 'h':
                    try {
                        int res = arr.showHead();
                        System.out.printf("First item in queue is %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }

        }
        System.out.println("System closed.");

    }
}
