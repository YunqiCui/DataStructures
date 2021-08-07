package com.cyunq.datastructures.linkedlist.josephu;

public class CircleSingleLinkedList {

    //create first node
    private Boy first = null;

    /**
     * @param nums total number of boys adding into circle single linked list
     */
    public void addBoy(int nums) {
        //data validation - nums must no less than 1
        if (nums < 1) {
            System.out.println("nums cannot be less than 1");
            return;
        }
        Boy cur = null;//辅助指针，帮助构建环形链表

        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //第一个节点比较特殊
            if (i == 1) {
                first = boy;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    /**
     * print circle single linked list
     */
    public void list() {
        if (first == null) {
            System.out.println("List is empty!");
        }
        Boy cur = first;
        while (true) {
            System.out.printf("Nodes number %d \n", cur.getNo());
            if (cur.getNext() == first) {//遍历完毕
                break;
            }
            cur = cur.getNext();
        }
    }


    /**
     * Josephu problem.
     *
     * @param startNo  starting point k
     * @param countNum skipped number m
     * @param nums     total number of elements n
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("Parameter entered is not correct. Please re enter.");
        }
        //assist pointer helper
        Boy helper = first;
        //helper 指向最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，让first 和 helper 移动k-1 次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //小孩报数时，让first 和 helper 指针同时移动m-1次，然后出圈
        while (true){
            if (helper == first){
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }//此时first 指向的节点就是要出圈的节点
            System.out.printf("Child %d excuted\n",first.getNo());

            //excute first node
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("Only node left in circle is number : %d \n",first.getNo());
    }
}
