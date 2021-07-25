package com.cyunq.treeadvance.binarysorttree;

import com.cyunq.treeadvance.huffmantree.Node;

public class BinarySortNode {
    public int value;
    public BinarySortNode left;
    public BinarySortNode right;

    public BinarySortNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinarySortNode{" + "value=" + value + '}';
    }

    /**
     * 用二叉排序树的方式添加节点
     *
     * @param node 待添加二叉排序树的节点
     */
    public void add(BinarySortNode node) {
        if (node == null) {
            return;
        }
        //判断传入的节点与当前子树的根节点的值
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }


}
