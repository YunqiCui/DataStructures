package com.cyunq.algorithms.binarysearchnonrecursion;

/**
 * 非递归的方式实现二分查找
 */
public class BinarySearch {

    public static int count;
    public static void main(String[] args) {

        //测试二分查找

        int[] arr = {1,3,8,10,11,67,1000};
        int index = binarySearch(arr, 1);
        System.out.println("Search Result = "+index);
        System.out.println(count);
    }

    /**
     *
     * @param arr 待查找的有序数组
     * @param target 查找值
     * @return 返回对应下标，没有则返回-1
     */
    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            count++;
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
