package com.cyunq.treebasic.arraybinarytree;

public class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载preOrder 方法
    public void preOrder() {
        System.out.println("Pre Order:-------------");
        this.preOrder(0);
        System.out.println();
    }

    public void infixOrder() {
        System.out.println("Infix Order:-------------");
        this.infixOrder(0);
        System.out.println();
    }

    public void postOrder() {
        System.out.println("Post Order:-------------");
        this.postOrder(0);
        System.out.println();
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is Empty");
        }
        System.out.print(arr[index] + " ");
        //向左递归遍历
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is Empty");
        }

        //向左递归遍历
        if (2 * index + 1 < arr.length) {
            infixOrder(2 * index + 1);
        }

        System.out.print(arr[index] + " ");

        //向右递归遍历
        if (2 * index + 2 < arr.length) {
            infixOrder(2 * index + 2);
        }
    }

    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is Empty");
        }

        //向左递归遍历
        if (2 * index + 1 < arr.length) {
            postOrder(2 * index + 1);
        }

        //向右递归遍历
        if (2 * index + 2 < arr.length) {
            postOrder(2 * index + 2);
        }

        System.out.print(arr[index] + " ");
    }
}
