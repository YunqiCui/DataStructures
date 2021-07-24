package com.cyunq.tree.binarytree;

public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public static int countPre = 0;
    public static int countInfix = 0;
    public static int countPost = 0;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
    public String toString() {
        return "HeroNode [no=" + no + ", name" + name + "]";
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        //递归左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        //递归左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        //递归向右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        //递归左子树
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
        //递归向右子树
    }

    //前序查找
    public HeroNode preSearch(int no) {
        countPre++;
        //比较当前节点
        if (this.no == no) {
            return this;
        }
        HeroNode res = null;
        //向左递归查找
        if (this.left != null) {
            res = this.left.preSearch(no);
        }
        if (res != null) {
            return res;
        }
        //向右递归查找
        if (this.right != null) {
            res = this.right.preSearch(no);
        }
        return res;
    }

    //中序查找
    public HeroNode infixSearch(int no) {

        HeroNode res = null;
        //向左递归查找
        if (this.left != null) {
            res = this.left.infixSearch(no);
        }
        if (res != null) {
            return res;
        }
        countInfix++;
        //比较当前节点
        if (this.no == no) {
            res = this;
        }
        //向右递归查找
        if (this.right != null) {
            res = this.right.infixSearch(no);
        }
        return res;
    }

    //后序查找
    public HeroNode postSearch(int no) {

        HeroNode res = null;
        //向左递归查找
        if (this.left != null) {
            res = this.left.postSearch(no);
        }
        if (res != null) {
            return res;
        }
        //向右递归查找
        if (this.right != null) {
            res = this.right.postSearch(no);
        }
        if (res != null) {
            return res;
        }
        countPost++;
        //比较当前节点
        if (this.no == no) {
            res = this;
        }
        return res;
    }

    /**
     * 只能通过判断当前节点的子节点是否需要删除才能实现方法
     * @param no Number node deleting.
     */
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            System.out.printf("Node id = %d name = %s and it's child nodes deleted.\n", this.left.no, this.left.name);
            this.left = null;
            return;
        } else if (this.right != null && this.right.no == no) {
            System.out.printf("Node id = %d name = %s and it's child nodes deleted.\n", this.right.no, this.right.name);
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}















































