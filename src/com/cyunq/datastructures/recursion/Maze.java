package com.cyunq.datastructures.recursion;

public class Maze {
    static int[][] map = new int[8][7];

    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        map(map);
        setWay2(map,1,1);
        map(map);
    }

    /**
     *
     * @param map
     */
    public static void map(int[][] map) {


        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][2] = 1;
        map[3][1] = 1;
        //遍历地图
        System.out.println("Current Map");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 约定一 如果小球到达【6】【5】，则表示通路找到
     * 约定二 当map[i][j] = 0 时，表示该店还没有走过，= 1 表示这是墙， 不能走
     * 如果等2， 表示通路，可以通行。如果为3，表示该点已经走过，但是走不通.
     * 约定三 在走迷宫时，需要先确定策略。我们假定，下 => 右 => 上 => 左，如果该点走不通，再回溯。
     *
     * @param map 迷宫地图
     * @param i   表示出发点的行
     * @param j   表示出发点的列
     * @return true 表示通路找到
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前点，还没有走。
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    //修改策略 上右下左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前点，还没有走。
                map[i][j] = 2;
                if (setWay2(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
