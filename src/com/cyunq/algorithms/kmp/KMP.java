package com.cyunq.algorithms.kmp;

import java.util.Arrays;

public class KMP {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext("ABCDABD");
        System.out.println(Arrays.toString(next));

        int res = kmpSearch(str1, str2, next);
        System.out.println(res);
    }

    /**
     * 获取一个字符串的部分匹配值表
     * @param dest 输入的字符串
     * @return 返回dest字符串的部分匹配值表
     */
    public static int[] kmpNext(String dest) {

        //创建一个next数组 保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {

            //当dest.charAt(i) != dest.charAt(j) 需要从next[j-1] 获取新的j
            //直到dest.charAt(i) == dest.charAt(j) 成立
            //这是KMP算法的核心点
            while (j >0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值+1
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     *
     * @param str1 原字符串
     * @param str2 查找字符串
     * @param next 查找值得部分匹配表
     * @return 返回找到的子串的起始下标，没有则返回-1
     */
    public static int kmpSearch(String str1, String str2, int[] next){

        //遍历str1
        for (int i = 0, j = 0; i < str1.length(); i++) {

            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j == str2.length()){
                return i - j + 1;
            }
        }
        return -1;
    }
}
