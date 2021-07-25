package com.cyunq.treebasic.binarytree;

public class BinaryTree {

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public HeroNode getRoot(){
        return this.root;
    }

    public void preOrder() {
        if (this.root != null) {
            System.out.println("Pre order traverse");
            System.out.println("------------------");
            this.root.preOrder();
        } else {
            System.out.println("Binary tree is empty");
        }
        System.out.println();
    }

    public void infixOrder() {
        System.out.println("Infix order traverse");
        System.out.println("------------------");
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("Binary tree is empty");
        }
        System.out.println();
    }

    public void postOrder() {
        System.out.println("Post order traverse");
        System.out.println("------------------");
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("Binary tree is empty");
        }
        System.out.println();
    }

    public void preSearch(int no) {
        HeroNode res = this.root.preSearch(no);
        if (this.root != null && res != null) {
            System.out.println("Pre order search");
            System.out.println("------------------");
            System.out.printf("Node found, id = %d , name = %s\n", res.getNo(), res.getName());
        } else {
            System.out.println("No such Node.");
        }
        System.out.println("Step taken = " + HeroNode.countPre + "\n");
    }

    public void infixSearch(int no) {
        HeroNode res = this.root.infixSearch(no);
        if (this.root != null && res != null) {
            System.out.println("Infix order search");
            System.out.println("------------------");
            System.out.printf("Node found, id = %d , name = %s\n", res.getNo(), res.getName());
        } else {
            System.out.println("No such Node.");
        }
        System.out.println("Step taken = " + HeroNode.countInfix + "\n");
    }

    public void postSearch(int no) {
        HeroNode res = this.root.postSearch(no);
        if (this.root != null && res != null) {
            System.out.println("Post order search");
            System.out.println("------------------");
            System.out.printf("Node found, id = %d , name = %s\n", res.getNo(), res.getName());
        } else {
            System.out.println("No such Node.");
        }
        System.out.println("Step taken = " + HeroNode.countPost + "\n");
    }

    /**
     *
     * @param no Number of node being deleted.
     */
    public void delNode(int no) {
        System.out.println("Delete Node");
        System.out.println("------------------");
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        }
        System.out.println("No such node!\n");
    }
}
