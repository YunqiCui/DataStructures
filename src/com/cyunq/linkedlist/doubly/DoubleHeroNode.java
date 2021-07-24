package com.cyunq.linkedlist.doubly;

public class DoubleHeroNode {
    //define hero node
    //each hero node object is a node in linked list
    public int no;
    public String name;
    public String nickname;
    public DoubleHeroNode next; // pin to next node
    public DoubleHeroNode pre; //pin to pre node

    public DoubleHeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + " ]";
    }
}
