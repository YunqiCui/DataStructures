package com.cyunq.linkedlist.single;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1, "Songjiang", "jishiyu");
        HeroNode hero2 = new HeroNode(2, "LuJunyi", "Yuqilin");
        HeroNode hero3 = new HeroNode(3, "Wuyong", "Zhiduoxing");
        HeroNode hero4 = new HeroNode(4, "LinChong", "Baozitou");
        HeroNode hero10 = new HeroNode(10, "10", "zitou");
        HeroNode hero19 = new HeroNode(19, "19", "19");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

        singleLinkedList.addbyorder(hero1);
        singleLinkedList.addbyorder(hero10);
        singleLinkedList.addbyorder(hero2);
        // singleLinkedList.addbyorder(hero2); 检查重复添加

        //测试修改节点

        singleLinkedList.list();

        System.out.println("-------------------");
        System.out.println();
        HeroNode newHeroNode = new HeroNode(2, "xiaolu", "111");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.list();

        System.out.println("-------------------");
        System.out.println();
        //测试删除节点
        singleLinkedList.delete(1);
        singleLinkedList.list();

        //点链表中有效节点个数
        System.out.println("链表中的有效节点个数为 " + getLength(singleLinkedList.getHead()));

        //测试倒数第K个节点
        HeroNode res = findIndexNode(singleLinkedList.getHead(), 4);
        System.out.println("-------------------");
        System.out.println();
        System.out.println("res = " + res);

        //单链表的反转
        System.out.println("Original List.");
        singleLinkedList.list();
        System.out.println("Reverse List.");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        //逆序打印单链表
        System.out.println("Reverse Print List");
        reversePrint(singleLinkedList.getHead());
        singleLinkedList.list();

        //合并两个单链表

        singleLinkedList2.addbyorder(hero19);
        singleLinkedList2.addbyorder(hero3);
        singleLinkedList2.addbyorder(hero4);

        System.out.println("First List");
        singleLinkedList.list();
        System.out.println("Second List");
        singleLinkedList2.list();
        System.out.println("Merged List");
        mergeList(singleLinkedList, singleLinkedList2).list();
    }

    //面试题1：获取单链表的节点的个数（带头结点的链表，需求不统计头节点）

    /**
     * @param head 链表的头结点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助变量
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //面试题2：查找单链表中倒数第K个节点
    //思路：
    //1.编写一个方法接受head节点,同时接收一个index
    //2.index 表示倒是第index节点
    //3.先把链表从头到尾遍历，得到链表的总长度getLength
    //4.得到size后，我们从链表的第一个开始遍历（size-index）个就得到结果
    //5.如果找到了，则返回该几点，否则返回一个空

    /**
     * @param head
     * @param index
     * @return cur
     */
    public static HeroNode findIndexNode(HeroNode head, int index) {
        //判断链表是否为空
        if (head.next == null) {
            return null;
        }
        //得到链表的长度
        int size = getLength(head);
        //先做一个index校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //面试题3： 单链表的反转

    /**
     * @param head
     */
    public static void reverseList(HeroNode head) {
        //如果链表为空 或者只有一个节点，不用反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表的最前面
        while (cur != null) {
            next = cur.next;//先暂时保存，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的头部
            reverseHead.next = cur;
            cur = next;
        }
        //将head.next 指向reverse.next
        head.next = reverseHead.next;
    }

    //面试题4: 逆序打印链表,使用栈的先进后出的特性

    /**
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;//cur 后移，这样就可以将下一个node压入栈
        }
        //打印栈的元素
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    //面试题5: 合并有序链表
    /**
     *
     * @param list1
     * @param list2
     * @return SingleLinkedList
     */
    public static SingleLinkedList mergeList(SingleLinkedList list1, SingleLinkedList list2) {

        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {//如果其中一个链表为空，直接返回另一个链表
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        SingleLinkedList ls = new SingleLinkedList();

        HeroNode temp = ls.getHead();
        HeroNode head1 = list1.getHead();
        HeroNode head2 = list2.getHead();

        while (head1.next != null && head2.next != null) {
            if (head1.next.no <= head2.next.no) {//比较两个链表的头结点，编号小的那一个，加入结果链表
                temp = head1.next;
                head1.next = head1.next.next;
            } else {
                temp = head2.next;
                head2.next = head2.next.next;
            }
            ls.addbyorder(temp);//将结果，加入链表
        }
        if (head1.next == null) {//将两个链表遍历后，剩下的最后一个值，加入结果链表
            ls.addbyorder(head2.next);
        } else {
            ls.addbyorder(head1.next);
        }
        return ls;
    }
}

