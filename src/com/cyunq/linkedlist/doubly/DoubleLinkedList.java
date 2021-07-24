package com.cyunq.linkedlist.doubly;

public class DoubleLinkedList {
    //initiate head node, not storing any data
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    public DoubleHeroNode getHead() {
        return this.head;
    }
    /**
     * add node into linked list
     * 思路：当不考虑编号顺序时
     * 1.找到链表的最后一个节点
     * 2.将最后节点的next，指向新节点
     *
     * @param doubleHeroNode
     */
    public void add(DoubleHeroNode doubleHeroNode) {
        //head节点不能动，因此我们需要一个辅助节点
        DoubleHeroNode temp = head;
        //for loop linked list, find the last Hero node.
        while (true) {
            if (temp.next == null) {
                break;
            }
            //if didnt find last node.
            temp = temp.next;
        }//当while循环退出时，就指向了链表的最后
        //形成一个双向链表
        temp.next = doubleHeroNode;
        doubleHeroNode.pre = temp;
    }

    /**
     * 双向链表的节点内容修改，和单向链表一样
     *
     * @param doubleHeroNode 双向链表
     */

    public void update(DoubleHeroNode doubleHeroNode) {
        if (head.next == null) {
            System.out.println("List is empty!");
        }
        //找到需要修改的节点
        DoubleHeroNode temp = head.next;
        boolean flag = false;//表示是否找到了该节点
        while (true) {
            if (temp == null) {
                break;//到达链表最后,退出
            }
            if (temp.no == doubleHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = doubleHeroNode.name;
            temp.nickname = doubleHeroNode.nickname;
        } else {
            System.out.printf("Didnt find Number %d, cannot update", doubleHeroNode.no);
        }
    }

    //show linked list
    public void list() {
        //check if list is empty
        if (head.next == null) {
            System.out.println("List is empty!");
        }
        DoubleHeroNode temp = head.next;
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

    /**
     * 删除节点
     * 对于双向链表，可以直接定位要删除的节点
     * 找到后，自我删除即可
     *
     * @param no 节点编号
     */
    public void delete(int no) {

        if (head.next == null) {
            System.out.println("List is empty, cannot delete.");
            return;
        }
        DoubleHeroNode temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {//到达链表的最后节点的next
                break;
            }
            if (temp.no == no) {
                //找到了待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断一下flag
        if (flag) {
            temp.pre.next = temp.next;
            //如果是最后一个节点，就不需要执行下面这句话,否则会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("Node %d not exists, cannot delete", no);
        }
    }
}


