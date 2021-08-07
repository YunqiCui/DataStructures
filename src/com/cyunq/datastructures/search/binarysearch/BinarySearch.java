package com.cyunq.datastructures.search.binarysearch;

import java.util.ArrayList;

public class BinarySearch {
    static int count1;
    static int count2;

    public static void main(String[] args) {

        /*int[] arr = {1, 8, 10, 89, 1000, 1234};//普通二分查找
        int resIndex = binarySearch(arr,0,arr.length-1,123);
        System.out.println("Index = " + resIndex);*/

        int[] arr = {1, 8, 10, 89, 1000, 1000, 2354};//全值二分查找
        ArrayList<Integer> resultList = fullBinarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndex = " + resultList);

    }

    /**
     * @param arr     查找的数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 查找值
     * @return 返回找到的下标，没找到则返回-1；
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        count1++;
        if (left > right) {//没有找到的判断
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {//向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    /**
     * * 课后思考题： {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
     * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
     * 1. 找到mid索引值，不要马上返回
     * 2. 向mid左边扫描，将所有满足findVal的元素下标，加入到集合ArrayList
     * 3. 向mid右边边扫描，将所有满足findVal的元素下标，加入到集合ArrayList
     * 4. 返回集合ArrayList
     *
     * @param arr     待查找的数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找值
     * @return 返回符合条件的下标的集合ArrayList 没有则返回空集合
     */
    public static ArrayList<Integer> fullBinarySearch(int[] arr, int left, int right, int findVal) {
        count2++;
        if (left > right) {//没有找到的判断
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {//向右递归
            return fullBinarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return fullBinarySearch(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();
            //向mid左边扫描
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == findVal) {
                //把temp放入集合中
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);//加入mid值
            //向mid右边边扫描
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == findVal) {

                //把temp放入集合中
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}
