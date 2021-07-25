package com.cyunq.treebasic.threadedbinarytree;


import com.cyunq.treebasic.binarytree.HeroNode;

public class ThreadedNode extends HeroNode {

    //1. 如果 leftType = 0，表示指向的是左子树，如果 =1 表示指向前驱节点
    //2. 如果 rightType = 0，表示指向的是右子树，如果 =1 表示指向后继节点
    private int leftType;
    private int rightType;
    private ThreadedNode parent;

    public ThreadedNode(int no,String name) {
        super(no,name);
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public ThreadedNode getParent() {
        return parent;
    }

    public void setParent(ThreadedNode parent) {
        this.parent = parent;
    }

    @Override
    public ThreadedNode getLeft() {
        return (ThreadedNode) super.getLeft();
    }

    @Override
    public void setLeft(HeroNode left) {
        super.setLeft(left);
    }

    @Override
    public ThreadedNode getRight() {
        return (ThreadedNode) super.getRight();
    }

    @Override
    public void setRight(HeroNode right) {
        super.setRight(right);
    }
}










































