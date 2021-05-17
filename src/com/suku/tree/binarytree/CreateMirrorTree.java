package com.suku.tree.binarytree;

public class CreateMirrorTree {

    //Approach recursive
    public static void mirror(TreeNode root) {
        mirrorCreator(root);
    }

    private static TreeNode mirrorCreator(TreeNode node) {
        // Base condition
        if(node == null) return node;

        //Find left and right
        TreeNode left = mirrorCreator(node.left);
        TreeNode right = mirrorCreator(node.right);

        //Swap left and right
        node.left = right;
        node.right = left;

        return node;
    }

    static void inOrder(TreeNode root)
    {
        inOrderRec(root);
    }

    /* Helper function to test mirror(). Given a binary
       search tree, print out its data elements in
       increasing sorted order.*/
    static void inOrderRec(TreeNode node)
    {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.val + " ");

        inOrder(node.right);
    }

    /* testing for example nodes */
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        inOrder(root);
        System.out.println("");

        /* convert tree to its mirror */
        mirror(root);

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        inOrder(root);

    }
}
