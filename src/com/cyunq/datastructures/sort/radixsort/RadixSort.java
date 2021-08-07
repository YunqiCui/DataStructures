package com.cyunq.datastructures.sort.radixsort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {1000,53, 3, 542, 748, 14, 214, 100, 194, 555};

        radixSort(arr);
        System.out.println(Arrays.toString(arr));

        //测试基数排序效率
        /*int[] arr = new int[90000000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是: " + dateStr);

        radixSort(arr);

        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是: " + dateStr2);*/
    }

    /**
     * 定义一个一位数组，表示10个桶，每个桶都是一个一维数组
     * 为了防止在存放数据时溢出，每个一位数组，大小定义为arr.length
     * 基数排序，就是使用空间换时间
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {

        //得到数组中最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length];

        //记录每个桶放了多少数据,定义一个一维数组，来记录每次放入的数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //一次取出每个元素的位数
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序（一位数组的下标一次取出数据，放入原来的数组）
            int index = 0;
            //遍历每一个桶，并将桶中的数据，放入到原来的数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出原数，放入到Array中
                        arr[index++] = bucket[k][l];
                    }
                }
                //将原来的桶清空
                bucketElementCounts[k] = 0;
            }
        }
    }
}
