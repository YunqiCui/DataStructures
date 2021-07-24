package com.cyunq.tree.heapsort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序排列
        int[] arr = {4, 6, 8, 5, 9,-1,90,89,-158};
        heapSort(arr);
    }

    /**
     * @param arr 待排序的数组
     */
    public static void heapSort(int[] arr) {
        int temp =0;
        System.out.println("Heap Sort");
        for (int i = arr.length/2 -1; i >=0; i--) {
            adjustHeap(arr,i, arr.length);
        }

        for (int j = arr.length-1; j >0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println("Array : "+Arrays.toString(arr));
    }

    /**
     * 功能：将数组调整成大顶堆
     *
     * @param arr    待调整的二叉树(数组)
     * @param i      非叶子节点在数组中的索引
     * @param length 需要调整的节点的个数
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];

        //1. k = i*2 + 1 ---->k 指向i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//左子节点 小于 右子节点
                k++;
            }
            if (arr[k] > temp) {//子节点大于父节点
                arr[i] = arr[k]; //把较大的值赋予当前节点
                i = k;//
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
