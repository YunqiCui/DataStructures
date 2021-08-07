package com.cyunq.datastructures.treeadvance.avltree;

import com.cyunq.datastructures.treeadvance.binarysorttree.BinarySortNode;

public class AvlNode extends BinarySortNode {

    public AvlNode(int value) {
        super(value);
    }

    /**
     * 返回左子树的高度
     *
     * @return 左子树的高度
     */
    public int leftHeight() {
        if ((AvlNode) left == null) {
            return 0;
        } else {
            return ((AvlNode) left).height();
        }
    }

    /**
     * 返回右子树的高度
     *
     * @return 右子树的高度
     */
    public int rightHeight() {
        if ((AvlNode) right == null) {
            return 0;
        } else {
            return ((AvlNode) right).height();
        }
    }

    /**
     * 返回当前节点为根节点的树的高度
     *
     * @return 返回当前节点的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : ((AvlNode) left).height(),
                right == null ? 0 : ((AvlNode) right).height()) + 1;
    }

    /**
     * 左旋转
     */
    public void leftRotate() {

        //以当前节点的值，创建新的节点
        AvlNode newNode = new AvlNode(value);

        //把新的节点的左子树，设置成当前节点的左子树
        newNode.left = left;

        //把新节点的右子树，设置成当前节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成右子节点的值
        value = right.value;
        //当前节点的右子树设置成右子树的右子树
        right = right.right;
        //把当前节点的左子树(左子节点)，设置为新的节点
        left = newNode;
    }

    /**
     * 右旋转
     */
    public void rightRotate() {

        //以当前节点，创建新的节点
        AvlNode newNode = new AvlNode(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    /**
     * @param node 待添加二叉排序树的节点
     * @Override
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

        if (rightHeight() - leftHeight() > 1) {
            if (right != null && ((AvlNode) right).leftHeight() > ((AvlNode) right).rightHeight()) {
                ((AvlNode) right).rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }

        if (leftHeight() - rightHeight() > 1) {
            if (left != null && ((AvlNode) left).rightHeight() > ((AvlNode) left).leftHeight()) {
                ((AvlNode) left).leftRotate();
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }
}
