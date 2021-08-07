package com.cyunq.datastructures.hashtable;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTable = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  add Emp");
            System.out.println("list: list Emp");
            System.out.println("find: search Emp");
            System.out.println("delete: delete Emp");
            System.out.println("exit: Exit Emp");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("Insert id");
                    int id = scanner.nextInt();
                    System.out.println("Insert name");
                    String name = scanner.next();
                    //create emp
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("id");
                    id = scanner.nextInt();
                    hashTable.findEmpById(id);
                    break;

                case "delete":
                    System.out.println("id");
                    id = scanner.nextInt();
                    hashTable.deleteEmp(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
