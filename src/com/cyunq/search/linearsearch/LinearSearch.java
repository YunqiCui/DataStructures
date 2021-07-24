package com.cyunq.search.linearsearch;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = linearSearch(arr, -11);
        if (index == -1) {
            System.out.println("No such value");
        } else {
            System.out.println("找到下标为 " + index);
        }
    }

    /**
     * 找到一个匹配值就返回的线性查找方法
     *
     * @param arr 查找的数据组
     * @param val 查找的数据
     * @return 返回数据的下标
     */
    public static int linearSearch(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
