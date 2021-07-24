package com.cyunq.search.fibonaccisearch;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] ints;
        ints = new int[]{1, 8, 10, 89, 1000, 1234};

        System.out.println(fibonacciSearch(ints, 777));
    }

    //使用非递归的方式，得到菲波那切数列
    public static int[] fibonacci() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
    //斐波那契查找算法

    /**
     * 非递归的方式
     *
     * @param arr 查找域
     * @param key 查找值
     * @return 返回查找值在数组中的对应下标，如果没有则返回-1
     */
    public static int fibonacciSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//表示斐波那契额数列数值的下标
        int mid = 0;
        int f[] = fibonacci();//获取斐波那契额数列

        //获取斐波那契额分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]值，可能大于数组的长度
        int[] temp = Arrays.copyOf(arr, f[k]);
        //需要使用数组后面的数填充
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        //使用循环处理，找到key值
        while (low <= high) {
            mid = low + f[k - 1] - 1;

            //k-- 与 k-=2
            //
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
