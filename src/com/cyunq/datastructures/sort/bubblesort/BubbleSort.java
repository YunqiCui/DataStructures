package com.cyunq.datastructures.sort.bubblesort;

import java.util.Arrays;

public class BubbleSort {
    private static int count = 0;

    public static void main(String[] args) {

        //时间复杂度 O(n²)
        int[] arr = {3, 9, -1, 10, -2};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
        System.out.println(count+"次排序");

        //测试冒泡排序的速度
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
//        bubbleSort(arr);
//
//        Date date2 = new Date();
//        String dateStr2 = simpleDateFormat.format(date2);
//        System.out.println("排序前的时间是: " + dateStr2);
    }

    public static void bubbleSort(int[] arr) {
        int temp;
        boolean flag = false;//标识是否进行过交换

        for (int i = 0; i < arr.length - 1; i++) {
            count++;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
