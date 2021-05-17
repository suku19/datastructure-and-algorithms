package com.suku.tree;

import com.suku.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return  null;
        return constructBST(nums, 0, nums.length-1);
    }

    public TreeNode constructBST(int num[], int left, int right) {
        if(left > right) return null;
        int mid = left + (right-left)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = constructBST(num, left, mid-1);
        node.right = constructBST(num, mid+1, right);
        return node;
    }
    public static void main(String[] args) {
        System.out.println("Root Node : " + new ArrayToBST().sortedArrayToBST(new int[]{1,2,3,4,5,6,7}));
    }
}
