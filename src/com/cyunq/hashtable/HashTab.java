package com.cyunq.hashtable;

public class HashTab {
    private EmpLinkedList[] empLinkedLists;
    private int size;//表示共有多少条链表
    public HashTab(int size){
        this.size = size;
        empLinkedLists= new EmpLinkedList[size];
        //分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }
    public void add(Emp emp){
        int empLinkedListNo = hashFun(emp.id);
        //调价到对应的链表中
        empLinkedLists[empLinkedListNo].add(emp);
    }
    //编写散列函数
    public int hashFun(int id){
        return id%size;
    }

    /**
     * 遍历哈希表
     */
    public void list(){
        for (int i = 0; i < size; i++) {
            System.out.println("List: "+i);
            empLinkedLists[i].list();
            System.out.println("----------------------");
        }
    }

    public void findEmpById(int id){
        //使用散列函数确定去哪一条链表里查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNO].findEmpById(id);
        if (emp!=null){
            System.out.printf("Find emp in list %d  Emp id = %d\n",empLinkedListNO+1,id);
        }else {
            System.out.println("Didnt find this Employee");
        }
    }

    public void deleteEmp(int id){
        int empLinkedListNO = hashFun(id);
        empLinkedLists[empLinkedListNO].deleteEmp(id);
    }
}