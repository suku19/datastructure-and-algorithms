package com.suku.tree;

import com.suku.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class PrintLevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i =0; i < size; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);

                /* Enqueue left child */
                if(current.left != null)
                    queue.add(current.left);
                /* Enqueue right child */
                if(current.right != null)
                    queue.add(current.right);
            }
            result.add(currentLevel);
        }

        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println("Is valid bfs : " + levelOrder(root));
    }
}
