package com.suku.tree.binarysearchtree;

public class Node {
    Node lchild;
    int info;
    Node rchild;

    public Node(int value) {
        info = value;
        lchild=null;
        rchild=null;
    }
}
