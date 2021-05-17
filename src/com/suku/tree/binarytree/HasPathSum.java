package com.suku.tree.binarytree;

public class HasPathSum {

    /*
     Given a tree and a sum,
     return true if there is a path
     from the root down to a leaf,
     such that adding up all
     the values along the path
     equals the given sum.

     Strategy: subtract the node
     value from the sum when
     recurring down, and check to
     see if the sum is 0 when
     you run out of tree.
     */

    static boolean hasPathSum(TreeNode node, int sum)
    {
        if (node == null)
            return sum == 0;
        return hasPathSum(node.left, sum - node.val)
                || hasPathSum(node.right, sum - node.val);
    }

    /* testing for example nodes */
    public static void main(String args[])
    {
        int sum = 22;

        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        /* creating a binary tree and entering the nodes */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        if (hasPathSum(root, sum))
            System.out.println(
                    "There is a root to leaf path with sum "
                            + sum);
        else
            System.out.println(
                    "There is no root to leaf path with sum "
                            + sum);
    }
}
