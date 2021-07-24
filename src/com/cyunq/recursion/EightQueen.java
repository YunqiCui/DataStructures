package com.cyunq.recursion;

/**
 * 八皇后问题
 */
public class EightQueen {

    int max = 8;
    int[] array = new int[max];//表示皇后放置位置的数组.数组下标表示行数，值表示列数。
    static int count = 0;
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);
        System.out.println("Total Solutions : "+count);
    }

    /**
     *
     * @param n 表示第n个皇后
     * @return 返回true or false 判断皇后放置是否冲突
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //判断array n 是否和前面的n-1个皇后在同一列或同一个斜线
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }return true;
    }

    /**
     * 输出八皇后解法
     */
    private void print(){
        count++;
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    /**
     * 放置皇后
     * @param n 代表放置的第几个皇后
     */
    private void check(int n){
        if (n == max){
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)){
                check(n+1);//放置下一个皇后
            }
            //如果冲突，就继续执行array[n]  = i;
        }
    }

}
