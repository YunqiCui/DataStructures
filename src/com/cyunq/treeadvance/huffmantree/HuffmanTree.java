package com.cyunq.treeadvance.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        preOrder(createHuffmanTree(arr));
    }

    /**
     * @param arr 待构建的数组
     */
    public static Node createHuffmanTree(int[] arr) {
        //遍历arr，将所有节点放入ArrayList
        ArrayList<Node> arrayList = new ArrayList<Node>();

        for (int value : arr) {
            arrayList.add(new Node(value));
        }

        while (arrayList.size() > 1) {
            //排序
            Collections.sort(arrayList);

            //取出根节点权值最小的两个二叉树
            Node left = arrayList.get(0);
            Node right = arrayList.get(1);

            //构建新的二叉树
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;

            //从ArrayList 删除处理过的二叉树
            arrayList.remove(left);
            arrayList.remove(right);
            arrayList.add(parent);
        }
        return arrayList.get(0);
    }

    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("This Tree is empty");
        }
    }
}
