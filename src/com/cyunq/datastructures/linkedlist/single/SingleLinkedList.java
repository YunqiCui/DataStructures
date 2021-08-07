package com.cyunq.datastructures.linkedlist.single;

public class SingleLinkedList {
    //initiate head node, not storing any data
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return this.head;
    }

    //add node into linked list
    //思路：当不考虑编号顺序时
    //1.找到链表的最后一个节点
    //2.将最后节点的next，指向新节点
    public void add(HeroNode heroNode) {
        //head节点不能动，因此我们需要一个辅助节点
        HeroNode temp = head;
        //for loop linked list, find the last heronode.
        while (true) {
            if (temp.next == null) {
                break;
            }
            //if didnt find last node.
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //按照英雄排名按顺序加入list

    public void addbyorder(HeroNode heroNode) {
        //因为头结点不能动
        //因此扔根据辅助变量，帮助找到添加的位置
        //temp 处于要添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false;//确定添加的节点是否存在, 默认为false

        while (true) {
            if (temp.next == null) {//说明temp已经到链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {//位置就在temp的后边插入
                break;
            } else if (temp.next.no == heroNode.no) {//希望添加的编号已经存在了
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//后移temp
        }
        //判断flag值
        if (flag) {//不能添加，说明编号存在
            System.out.printf("Hero %d exists.\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点:根据Heronode no 来修改
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("List is empty!");
        }
        //找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到了该节点
        while (true) {
            if (temp == null) {
                break;//到达链表最后,退出
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else {
            System.out.printf("Didnt find Number %d, cannot update", heroNode.no);
        }
    }

    //删除节点
    //temp.next.no = 待删除的节点的no 进行比较

    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {//到达链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到了待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断一下flag
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("Node %d not exists, cannot delete", no);
        }
    }

    //show linked list
    public void list() {
        //check if list is empty
        if (head.next == null) {
            System.out.println("List is empty!");
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //Show linked list
            System.out.println(temp);
            //将next后移
            temp = temp.next;
        }
    }
}
