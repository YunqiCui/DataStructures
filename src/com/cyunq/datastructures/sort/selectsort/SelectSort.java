package com.cyunq.datastructures.sort.selectsort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1,-1,90,123};
        selectSort(arr);
        System.out.println("After sort: " + Arrays.toString(arr));

        //测试选择排序的速度
//        int[] arr = new int[80000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int)(Math.random()*8000000);
//        }
//
//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateStr = simpleDateFormat.format(date1);
//        System.out.println("排序前的时间是: " + dateStr);
//
//        selectSort(arr);
//
//        Date date2 = new Date();
//        String dateStr2 = simpleDateFormat.format(date2);
//        System.out.println("排序前的时间是: " + dateStr2);
    }

    /**
     * 按从小到大排序数组
     * 选择排序时间复杂度 O(n²)
     * @param arr
     */
    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {//一次挑出数组里剩下的数里面的第一个数
            int minIndex = i;
            int min = arr[minIndex];
            for (int j = i + 1; j < arr.length; j++) {//将外层循环的数 与后面的所有数字比较
                if (arr[minIndex] > arr[j]) {//想要从大到小排列：arr[minIndex] < arr[j]
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];//先将当前的点放到最小点原来的位置
                arr[i] = min;//把第一个位置
            }
        }
    }
}
