package com.cyunq.treeadvance.binarysorttree;

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

    /**
     * 中序排序二叉排序树
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }


    /**
     *
     * @param value 查找的节点值
     * @return 返回找到的节点，如果树中不存在则返回null
     */
    public BinarySortNode search(int value){
        if (value == this.value){//找到了，就是该节点
            return this;
        }else if(value < this.value && this.left != null){
            return this.left.search(value);
        }else if (value >= this.value && this.right != null){
            return this.right.search(value);
        }else {
            return null;
        }
    }

    /**
     *
     * @param value 要找的节点值
     * @return 返回value节点的父节点，如果没有则返回null
     */
    public BinarySortNode searchParent(int value){
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else if (value < this.value && this.left != null){
            return this.left.searchParent(value);
        }else if (value >= this.value && this.right != null){
            return this.right.searchParent(value);
        }else{
            return null;
        }
    }
}
