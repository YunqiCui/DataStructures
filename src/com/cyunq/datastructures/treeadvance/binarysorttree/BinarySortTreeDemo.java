package com.cyunq.datastructures.treeadvance.binarysorttree;

public class BinarySortTreeDemo {
    private static BinarySortTree binarySortTree;
    public static void main(String[] args) {

        int[] arr =  {7,3,10,12,5,1,9,2};
        testBinarySortTree(arr);

        testDelNode(2);
        testDelNode(5);
        testDelNode(9);
        testDelNode(12);
        testDelNode(7);
        testDelNode(3);
        testDelNode(10);
        testDelNode(1);
//        testDelNode(10);

    }

    private static void testBinarySortTree(int[] arr){
        binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new BinarySortNode(i));
        }
        binarySortTree.infixOrder();
    }

    private static void testDelNode(int val){
        if (binarySortTree != null){
            System.out.println("----------------------------");
            System.out.println("Tree after delete node " + val);
            binarySortTree.deleteNode(val);
            binarySortTree.infixOrder();
        }else {
            System.out.println("Binary Sort Tree is empty");
        }
    }
}
