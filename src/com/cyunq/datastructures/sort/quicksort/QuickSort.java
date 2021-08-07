package com.cyunq.datastructures.sort.quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        //测试快速排序的效率
       /* int[] arr = new int[90000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是: " + dateStr);

        quickSort(arr,0,arr.length-1);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是: " + dateStr2);*/
    }

    /**
     *
     * @param arr 处理的数组
     * @param left 当前处理数组的左边index，最左边的值
     * @param right 当前处理数组的右边边index，最右边边的值
     */
    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        //pivot 中轴
        int pivot = arr[(left+right)/2];
        int temp = 0;
        while (l < r){//比pivot小的值放到左边，比pivot大的值放到右边
            while (arr[l] < pivot){//在pivot的左边遍历，找到大于pivot的数
                l++;
            }
            while (arr[r] > pivot){//在pivot的右边遍历，找到小于pivot的数
                r--;
            }
            if (l>=r){
                break;
            }
            //交换l 和 r
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现arr[l] == pivot的值, r 前移一步
            if (arr[l] == pivot){
                r--;
            }
            //如果交换完后，发现arr[r] == pivot的值, l 后移一步
            if (arr[r] == pivot){
                l++;
            }
        }

        //递归之前的判断
        if (l == r){
            l++;
            r--;
        }
        //左递归
        if (left < r){
            quickSort(arr,left,r);
        }
        //右递归
        if (right > l){
            quickSort(arr,l,right);
        }
    }
}
