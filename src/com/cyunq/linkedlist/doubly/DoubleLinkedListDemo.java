package com.cyunq.linkedlist.doubly;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("Double Linked List Test Demo.");

        DoubleHeroNode hero1 = new DoubleHeroNode(1, "Songjiang", "jishiyu");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "LuJunyi", "Yuqilin");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "Wuyong", "Zhiduoxing");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "LinChong", "Baozitou");
        DoubleHeroNode hero10 = new DoubleHeroNode(10, "10", "zitou");
        DoubleHeroNode hero19 = new DoubleHeroNode(19, "19", "19");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //add
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //update
        System.out.println("Test Update");
        DoubleHeroNode newHeroNode = new DoubleHeroNode(4,"abc","def");
        doubleLinkedList.update(newHeroNode);
        System.out.println("Updated List");
        doubleLinkedList.list();

        //delete
        doubleLinkedList.delete(3);
        System.out.println("List after delete.");
        doubleLinkedList.list();
    }



}
