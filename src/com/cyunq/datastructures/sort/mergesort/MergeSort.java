package com.cyunq.datastructures.sort.mergesort;

import java.util.Arrays;

public class MergeSort {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);

        //测试并归排序效率
        /*int[] arr = new int[90000000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是: " + dateStr);

        mergeSort(arr, 0, arr.length - 1, temp);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是: " + dateStr2);*/

    }

    /**
     *
     * @param arr 待排序数组
     * @param left 起始索引
     * @param right 右边索引
     * @param temp 临时数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间索引
            //向左递归，进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归，进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param arr   待排序的数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        count++;
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid + 1;//初始化j，右边边有序序列的初始索引
        int t = 0;//temp 临时数组的索引

        //（一）
        //先把左右两边的数据（有序），按规则填充到temp中去
        //直到左右两边有一组处理完毕

        while (i <= mid && j <= right) {
            //如果左边有序序列的当前元素小于右边的元素
            //将i的元素拷贝到temp数组中
            //t 和 i 后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //（二）
        //将剩余一边的数据一次填入temp
        while (i <= mid) {//左边的有序序列还有剩余元素，全部填充到temp中
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {//右边的有序序列还有剩余元素，全部填充到temp中
            temp[t] = arr[j];
            t++;
            j++;
        }
        //（三）
        //将temp拷贝到原数组中去
        //并不是每次都是讲temp中的所有数据都拷贝进去
        t = 0;
        int templeft = left;
        while (templeft <= right) {
            arr[templeft] = temp[t];
            t++;
            templeft++;
        }
    }
}
