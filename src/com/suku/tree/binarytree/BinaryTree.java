package com.suku.tree.binarytree;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void display() {
        display(root, 0);
    }

    private void display(TreeNode p, int level) {
        int i;

        if(p==null) return;

        display(p.right, level+1);
        System.out.println();

        for(i =0; i<level; i++)
            System.out.print("    ");
        System.out.println(p.val);

        display(p.left, level+1);
    }

    private void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(TreeNode p) {
        if(p == null) return;
        System.out.print(p.val +" ");
        preOrder(p.left);
        preOrder(p.right);
    }

    private void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(TreeNode p) {
        if(p == null) return;
        inOrder(p.left);
        System.out.print(p.val +" ");
        inOrder(p.right);
    }

    private void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(TreeNode p) {
        if(p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        System.out.print(p.val +" ");
    }

    public void createTree() {
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.createTree();

        binaryTree.display();

        System.out.println("Preorder Traversal: ");
        binaryTree.preOrder();

        System.out.println("Inorder Traversal: ");
        binaryTree.inOrder();

        System.out.println("Postorder Traversal: ");
        binaryTree.postOrder();
    }


}
