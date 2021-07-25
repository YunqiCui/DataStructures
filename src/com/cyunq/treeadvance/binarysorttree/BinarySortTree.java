package com.cyunq.treeadvance.binarysorttree;

public class BinarySortTree {
    private BinarySortNode root;

    public void add(BinarySortNode node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else {
            System.out.println("Current Binary Sort Tree is empty!");
        }
    }
}
