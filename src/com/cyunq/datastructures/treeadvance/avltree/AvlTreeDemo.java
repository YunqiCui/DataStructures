package com.cyunq.datastructures.treeadvance.avltree;


public class AvlTreeDemo {

    public static void main(String[] args) {
        System.out.println("Left Rotate");
        System.out.println("------------");
        int[] arr = {4, 3, 6, 5, 7, 8};
        testRotate(arr);

        System.out.println();
        System.out.println("Right Rotate");
        System.out.println("------------");
        int[] arr1 = {10, 12, 8, 9, 7, 6};
        testRotate(arr1);

        System.out.println();
        System.out.println("Double Rotate");
        System.out.println("------------");
        int[] arr2 = {10, 11, 7, 6, 8, 9};
        testRotate(arr2);

        System.out.println();
        System.out.println("Double Rotate");
        System.out.println("------------");
        int[] arr3 = {2, 1, 6, 5, 7, 3};
        testRotate(arr3);
    }

    public static void testRotate(int[] arr) {
        AvlTree avlTree = new AvlTree();

        for (int i : arr) {
            avlTree.add(new AvlNode(i));
        }
        System.out.println("平衡处理后");
        avlTree.infixOrder();
        displayTreeHeight(avlTree);
        System.out.println("Root Node : " + avlTree.getRoot());
    }

    public static void displayTreeHeight(AvlTree avlTree) {
        System.out.println("树的高度" + ((AvlNode) avlTree.getRoot()).height());
        System.out.println("左子树高度" + ((AvlNode) avlTree.getRoot()).leftHeight());
        System.out.println("右子树高度" + ((AvlNode) avlTree.getRoot()).rightHeight());
        System.out.println();
    }
}
