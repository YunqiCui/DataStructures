package com.cyunq.tree.threadedbinarytree;

/**
 * 测试
 *     1. 二叉树的中序遍历，先序遍历，后序遍历
 *     2. 二叉树的中序索引化，先序索引化，后序索引化
 *     3. 二叉树的中序索引化遍历，先序索引化遍历，后序索引化遍历
 */
public class ThreadedBinaryTreeDemo {
    private static ThreadedBinaryTree tree;
    private static ThreadedNode node5;

    public static void main(String[] args) {
        testInfix();
        System.out.println("************************");
        testPrefix();
        System.out.println("************************");
        testPost();
    }

    private static void testPost() {
        ThreadedBinaryTreeDemo app = new ThreadedBinaryTreeDemo();
        app.resetTree(); // 重置测试数据
        System.out.println("后序遍历结果:");
        tree.postOrder(); // 打印先序遍历结果
        tree.postThreadNode(); // 对二叉树进行先序索引化

        // 测试节点[10, King]的前驱和后继
        System.out.println("\n[10,King]的前驱和后继: ");
        System.out.println("前驱: " + node5.getLeft()); // [8,Mary]
        System.out.println("后继: " + node5.getRight());// [6,Smith]
        // 测试经过中序线索华后的遍历结果
        System.out.println("\n经过后序线索化后的遍历结果:");
        tree.postThreadList();
    }

    private static void testPrefix() {
        ThreadedBinaryTreeDemo app = new ThreadedBinaryTreeDemo();
        app.resetTree(); // 重置测试数据
        System.out.println("先序遍历结果:");
        tree.preOrder(); // 打印先序遍历结果
        tree.preThreadNode(); // 对二叉树进行先序索引化

        // 测试节点[10, King]的前驱和后继
        System.out.println("\n[10,King]的前驱和后继: ");
        System.out.println("前驱: " + node5.getLeft()); // [8,Mary]
        System.out.println("后继: " + node5.getRight());// [6,Smith]
        // 测试经过中序线索华后的遍历结果
        System.out.println("\n经过前序线索化后的遍历结果:");
        tree.preThreadList();
    }

    private static void testInfix() {
        ThreadedBinaryTreeDemo app = new ThreadedBinaryTreeDemo();
        app.resetTree();   //重置测试数据
        System.out.println("中序遍历结果");
        tree.infixOrder(); //打印中序遍历结果
        tree.infixThreadNode(); // 对二叉树进行中序遍历索引化
        // 测试节点[10, King]的前驱和后继
        System.out.println("\n[10,King]的前驱和后继: ");
        System.out.println("前驱: " + node5.getLeft()); // [3, Jack]
        System.out.println("后继: " + node5.getRight());// [1, Tom]
        // 测试经过中序线索化后的遍历结果
        System.out.println("\n经过中序线索化后的遍历结果:");
        tree.infixThreadList();
    }

    private void resetTree() {
        ThreadedNode root = new ThreadedNode(1, "Tom");
        ThreadedNode node2 = new ThreadedNode(3, "Jack");
        ThreadedNode node3 = new ThreadedNode(6, "Smith");
        ThreadedNode node4 = new ThreadedNode(8, "Mary");
        ThreadedNode node5 = new ThreadedNode(10, "King");
        ThreadedNode node6 = new ThreadedNode(14, "Dim");
        ThreadedBinaryTreeDemo.node5 = node5; // 供测试用
        // 手动创建二叉树, parent指针用来辅助后序线索化
        root.setLeft(node2);
        node2.setParent(root);
        root.setRight(node3);
        node3.setParent(root);
        node2.setLeft(node4);
        node4.setParent(node2);
        node2.setRight(node5);
        node5.setParent(node2);
        node3.setLeft(node6);
        node6.setParent(node3);
        tree = new ThreadedBinaryTree();
        tree.setRoot(root);
    }
}