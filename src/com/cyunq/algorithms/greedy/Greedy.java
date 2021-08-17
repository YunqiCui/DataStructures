package com.cyunq.algorithms.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Greedy {
    private static HashSet<String> hashset1;
    private static HashSet<String> hashset2;
    private static HashSet<String> hashset3;
    private static HashSet<String> hashset4;
    private static HashSet<String> hashset5;
    private static HashMap<String, HashSet<String>> broadcasts;
    private static HashSet<String> allAreas;

    public static void main(String[] args) {
        createBroadCast();
        showHashSet();
        showHashMap();
        allAreas();
        showAllAreas();
        testGreedy();
    }

    private static void testGreedy(){
        ArrayList<String> res = greedy();
        System.out.println("res = " + res);
        allAreas();
    }

    private static ArrayList<String> greedy() {
        //创建ArrayList，存放选择的电台
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时集合，存放电台覆盖的地区和当前还没有覆盖的地区的集合
        HashSet<String> temp = new HashSet<String>();

        //定义maxKey，能够覆盖最大未覆盖的地区对应的电台
        //如果maxKey 不为空，就加入selects List

        String maxKey = null;
        while (allAreas.size() != 0) {
            maxKey = null;
            //遍历broadcast,取出对应key
            for (String key : broadcasts.keySet()) {
                temp.clear();
                HashSet<String> areas = broadcasts.get(key);
                temp.addAll(areas);
                temp.retainAll(allAreas);//求出temp与allAreas集合的交集
                //如果当前集合包含的未覆盖地区的数量比maxKey 指向的集合还要多，那maxKey 就指向这个集合
                //maxKey == null || temp.size() > broadcasts.get(maxKey).size()) 体现出贪心算法的特性
                if (temp.size() > 0 && (maxKey == null || temp.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }

            if (maxKey != null) {
                selects.add(maxKey);
                //将maxkey 覆盖的地区，从allAreas清楚
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        return selects;
    }


    private static void createBroadCast() {
        //将广播电台放入HashMap中去
        broadcasts = new HashMap<String, HashSet<String>>();

        hashset1 = new HashSet<String>();
        hashset2 = new HashSet<String>();
        hashset3 = new HashSet<String>();
        hashset4 = new HashSet<String>();
        hashset5 = new HashSet<String>();

        hashset1.add("北京");
        hashset1.add("上海");
        hashset1.add("天津");

        hashset2.add("广州");
        hashset2.add("上海");
        hashset2.add("深圳");

        hashset3.add("成都");
        hashset3.add("上海");
        hashset3.add("杭州");

        hashset4.add("上海");
        hashset4.add("天津");

        hashset5.add("杭州");
        hashset5.add("大连");

        broadcasts.put("K1", hashset1);
        broadcasts.put("K2", hashset2);
        broadcasts.put("K3", hashset3);
        broadcasts.put("K4", hashset4);
        broadcasts.put("K5", hashset5);
    }

    private static void showHashSet() {
        System.out.println();
        System.out.println(hashset1);
        System.out.println(hashset2);
        System.out.println(hashset3);
        System.out.println(hashset4);
        System.out.println(hashset5);
        System.out.println();
    }

    private static void showHashMap() {
        System.out.println();
        System.out.println("广播电台集合 ： " + broadcasts);
        System.out.println();
    }

    private static void allAreas() {
        allAreas = new HashSet<String>();

        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("杭州");
        allAreas.add("成都");
        allAreas.add("大连");
        allAreas.add("深圳");
    }

    private static void showAllAreas() {
        System.out.println("所有电台 = " + allAreas);
    }
}
