package com.cyunq.sort.shellsort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Dictionary;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

        //测试交换希尔排序的速度
//        int[] arr = new int[8000000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int)(Math.random()*8000000);
//        }
//
//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateStr = simpleDateFormat.format(date1);
//        System.out.println("排序前的时间是: " + dateStr);
//
//        shellSort(arr);
//
//        Date date2 = new Date();
//        String dateStr2 = simpleDateFormat.format(date2);
//        System.out.println("排序前的时间是: " + dateStr2);
    }

    /**
     * 移位法插入排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {

        //交换法插入
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中，所有的元素(步长等于gap)
                int j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当while退出后，就找到了插入的位置
                    arr[j] = temp;
                }
            }
//            System.out.println("希尔排序第"+(++count)+ Arrays.toString(arr));
        }
    }
}
