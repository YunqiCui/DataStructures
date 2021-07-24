package com.cyunq.sort.insertionsort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, 900, 50};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

        //测试插入排序的速度
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
//        insertionSort(arr);
//
//        Date date2 = new Date();
//        String dateStr2 = simpleDateFormat.format(date2);
//        System.out.println("排序前的时间是: " + dateStr2);
    }

    public static void insertionSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i-1;
            //1. 在给insertval找插入位置时，不越界。
            //2. 待插入数据还没有找到位置
            //3. 将insertIndex值往后移动
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {//如果从大到小排序，改成insertVal > arr[insertIndex]
                arr[insertIndex + 1] = arr[insertIndex];//{101,101,119,1}
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到 insertVal + 1
            //判断是否需要赋值
            if (arr[insertIndex + 1] != insertVal) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
