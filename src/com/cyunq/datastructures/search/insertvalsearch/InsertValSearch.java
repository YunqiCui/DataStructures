package com.cyunq.datastructures.search.insertvalsearch;

public class InsertValSearch {
    static int count;

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int res = insertValSearch(arr, 0, arr.length - 1, 33);
        System.out.println(res);
        System.out.println(count);
    }

    /**
     * 需要数组是有序的
     *
     * @param arr     查找域
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找值
     * @return 返回找到的值对应的下标，如果没有找到则返回-1
     */
    public static int insertValSearch(int[] arr, int left, int right, int findVal) {
        count++;//检测代码执行次数
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        //求出mid值,自适应的写法
        int mid = left + (right - left) * (findVal - arr[left]) /
                (arr[right] - arr[left]);

        int midVal = arr[mid];

        if (findVal > midVal) {//向右递归
            return insertValSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {//向左递归
            return insertValSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}