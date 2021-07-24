package com.cyunq.hashtable;

public class EmpLinkedList {
    private Emp head;

    //假定添加雇员的时候，加在链表的最后
    //id 号码自增长
    public void add(Emp emp){
        //如果是添加第一个雇员
        if (head == null){
            head = emp;
            return;
        }
        //如果不是添加第一个雇员
        Emp cur = head;
        while (true){
            if (cur.next == null){
                break;
            }
                cur = cur.next;
        }
        cur.next = emp;
    }

    public void list(){
        if (head == null){
            System.out.println("List is null");
            return;
        }
        System.out.println("当前链表信息为：");
        Emp cur = head;
        while (true){
            System.out.printf("=> id = %d name=%s\t",cur.id,cur.name);
            if (cur.next == null){
                break;
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id){
        //判断链表是否为空
        if (head == null){
            return null;
        }
        //辅助指针
        Emp cur = head;
        while (true){
            if (cur.id == id){
                break;
            }
            if (cur.next == null){
                cur = null;
                break;
            }
            cur = cur.next;
        }
        return cur;
    }

    public void deleteEmp(int id){
        Emp cur = head;

        if (head != null && head.id == id) {
            head = null;
            System.out.println("Emp : "+id+" deleted.");
            return;
        }
        while (cur != null){
            if (cur.next == null){
                System.out.println("Didn't find Emp "+id +" to delete");
                break;
            } else if (cur.next.id == id){
                cur.next = cur.next.next;
                System.out.println("Emp : "+id+" deleted.");
                break;
            }
            cur = cur.next;
        }
    }
}
