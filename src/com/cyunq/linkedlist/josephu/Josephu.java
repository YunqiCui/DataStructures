package com.cyunq.linkedlist.josephu;

public class Josephu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.list();
        System.out.printf("Excuted order\n");
        circleSingleLinkedList.countBoy(1,2,5);
    }
}
