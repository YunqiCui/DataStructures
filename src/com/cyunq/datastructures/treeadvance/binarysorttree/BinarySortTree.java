package com.cyunq.datastructures.treeadvance.binarysorttree;

public class BinarySortTree {
    private BinarySortNode root;

    public BinarySortNode getRoot() {
        return root;
    }

    public void setRoot(BinarySortNode root) {
        this.root = root;
    }

    public void add(BinarySortNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        System.out.println();
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("Current Binary Sort Tree is empty!");
        }
    }

    /**
     * @param value 查找值
     * @return 调用BinarySearchNode中的 search方法返回值
     */
    public BinarySortNode search(int value) {
        BinarySortNode target;
        if (root == null) {
            return null;
        } else {
            target = root.search(value);
            if (target != null) {
                return target;
            } else {
                return null;
            }
        }
    }

    /**
     * @param value 查找值
     * @return 调用BinarySearchNode中的 searchParent方法返回值
     */
    public BinarySortNode searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }


    public int delRightTreeMin(BinarySortNode target) {
        while (target.left != null) {
            target = target.left;
        }
        deleteNode(target.value);
        return target.value;
    }

    public void deleteNode(int value) {
        if (root != null) {
            BinarySortNode targetNode = search(value);
            if (targetNode == null) {
                System.out.println("No such node in Binary Sort Tree");
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            BinarySortNode parent = searchParent(value);
            //删除叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && targetNode == parent.left) {
                    parent.left = null;
                } else if (parent.right != null && targetNode == parent.right) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//删除两个子树的节点
                //在targetNode的右子树向左查找
                targetNode.value = delRightTreeMin(targetNode.right);
            } else {//删除只有一个颗子树的节点
                //如果删除的节点有左子节点
                if (targetNode.left != null) {
                    if (parent != null) {//考虑父节点是否为空的情况
                        if (targetNode == parent.left) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    if (parent != null) {
                        if (targetNode == parent.left) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
}
