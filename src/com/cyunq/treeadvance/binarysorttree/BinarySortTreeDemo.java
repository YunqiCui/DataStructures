package com.cyunq.treeadvance.binarysorttree;

public class BinarySortTreeDemo {
    private static BinarySortTree binarySortTree;
    public static void main(String[] args) {

        int[] arr =  {7,3,10,12,5,1,9};
        testBinarySortTree(arr);
        binarySortTree.infixOrder();
    }

    private static void testBinarySortTree(int[] arr){
        binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new BinarySortNode(i));
        }
    }
}
