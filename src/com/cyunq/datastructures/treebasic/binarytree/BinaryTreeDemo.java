package com.cyunq.datastructures.treebasic.binarytree;

public class BinaryTreeDemo {

    public static void main(String[] args) {

        //Create Binary Tree

        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");


        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

        //前序遍历
        binaryTree.preOrder();//1 2 3 5 4

        //中序遍历
        binaryTree.infixOrder();//2 1 5 3 4

        //后序遍历
        binaryTree.postOrder();//2 5 4 3 1

        //前序查找
        binaryTree.preSearch(5);
        //中序查找
        binaryTree.infixSearch(5);
        //后序查找
        binaryTree.postSearch(5);

        binaryTree.delNode(6);
        binaryTree.preOrder();
    }
}
