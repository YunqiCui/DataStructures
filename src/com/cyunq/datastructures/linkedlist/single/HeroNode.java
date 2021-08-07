package com.cyunq.datastructures.linkedlist.single;

public class HeroNode {
    //define hero node
    //each hero node object is a node in linked list
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // pin to next node

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + " ]";
    }
}
