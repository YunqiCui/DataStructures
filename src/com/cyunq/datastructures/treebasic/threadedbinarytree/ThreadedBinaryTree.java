package com.cyunq.datastructures.treebasic.threadedbinarytree;

import com.cyunq.datastructures.treebasic.binarytree.BinaryTree;
import com.cyunq.datastructures.treebasic.binarytree.HeroNode;

public class ThreadedBinaryTree extends BinaryTree {
    //指向前驱节点的指针
    private ThreadedNode pre = null;

    public ThreadedBinaryTree() {
        super();
    }

    @Override
    public void setRoot(HeroNode root) {
        super.setRoot(root);
    }

    @Override
    public ThreadedNode getRoot() {
        return (ThreadedNode) super.getRoot();
    }

    public void preThreadNode() {
        this.preThreadNode(getRoot());
    }

    public void infixThreadNode() {
        this.infixThreadNode(getRoot());
    }

    public void postThreadNode() {
        this.postThreadNode(getRoot());
    }

    /**
     * 前序线索化二叉树
     *
     * @param threadedNode 需要线索化的节点
     *                     1 3 6 8 10 11
     */
    public void preThreadNode(ThreadedNode threadedNode) {
        if (threadedNode == null) {
            return;
        }
        //一）线索化当前节点
        currentNode(threadedNode);
        //二）线索化左子树
        if (threadedNode.getLeftType() == 0) {
            preThreadNode(threadedNode.getLeft());
        }

        //三）线索化右子树
        if (threadedNode.getRightType() == 0) {
            preThreadNode(threadedNode.getRight());
        }
    }


    /**
     * 中序线索化的方法
     *
     * @param threadedNode 需要线索化的节点
     */
    public void infixThreadNode(ThreadedNode threadedNode) {
        if (threadedNode == null) {
            return;
        }
        //一）线索化左子树
        infixThreadNode(threadedNode.getLeft());

        //二）线索化当前节点
        currentNode(threadedNode);

        //三）线索化右子树
        infixThreadNode(threadedNode.getRight());
    }

    public void postThreadNode(ThreadedNode threadedNode) {
        if (threadedNode == null) {
            return;
        }
        //一）线索化左子树
        if (threadedNode.getLeftType() == 0) {
            postThreadNode(threadedNode.getLeft());
        }

        //二）线索化右子树
        if (threadedNode.getRightType() == 0) {
            postThreadNode(threadedNode.getRight());
        }

        //三）线索化当前节点
        currentNode(threadedNode);
    }

    public void currentNode(ThreadedNode threadedNode){
        //处理当前指针的前驱节点
        if (threadedNode.getLeft() == null) {
            //当前节点的做指针指向前驱节点
            threadedNode.setLeft(pre);
            //修改当前节点的做指针类型
            threadedNode.setLeftType(1);
        }
        //处理后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(threadedNode);
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点，是下一个节点的前驱节点
        pre = threadedNode;
    }

    /**
     * 中序遍历线索化二叉树
     */
    public void infixThreadList() {
        //定义一个变量，存储当前的节点
        ThreadedNode node = getRoot();

        while (node != null) {
            //循环的找到leftType == 1 的节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //打印当前这个节点
            System.out.println(node);

            //如果当前节点的指针指向的是后继节点
            while (node.getRightType() == 1) {
                //获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换遍历的节点
            node = node.getRight();
        }
    }

    /**
     * 前序遍历线索化二叉树
     */
    public void preThreadList() {
        //定义一个变量，存储当前的节点
        ThreadedNode node = getRoot();
        while (node != null) {
            //循环的找到leftType == 0 的节点
            while (node.getLeftType() == 0) {
                //打印当前这个节点
                System.out.println(node);
                node = node.getLeft();
            }
            System.out.println(node);
            //替换遍历的节点
            node = node.getRight();
        }
    }

    /**
     * 后序遍历，线索化二叉树
     */
    public void postThreadList() {

        //定义一个变量，存储当前的节点
        ThreadedNode node = getRoot();

        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            while (node != null && node.getRightType() == 1) {
                System.out.println(node);
                pre = node;
                node = node.getRight();
            }
            if (node == getRoot()){
                System.out.println(node);
                return;
            }
            while (node!=null && node.getRight() == pre){
                System.out.println(node);
                pre = node;
                node = node.getParent();
            }
            if (node != null && node.getRightType()==0){
                node = node.getRight();
            }
        }
    }
}
