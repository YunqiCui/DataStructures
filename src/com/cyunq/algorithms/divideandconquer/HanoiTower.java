package com.cyunq.algorithms.divideandconquer;

/**
 * 分治算法的实现 - 汉诺塔
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + " -> " + c);
        }else {
            //如果 n>=2
            //先把最上面的所有盘 A -> B, 移动过程会借助C
            hanoiTower(num-1,a,c,b);
            //把最下面的盘，A -> C
            System.out.println("第"+num+"个盘从 " + a + " -> " + c);
            //把b塔的所有盘 从B -> C, 移动过程使用到A
            hanoiTower(num -1,b,a,c);
        }
    }
}
