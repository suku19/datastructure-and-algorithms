package com.suku.tree.binarysearchtree;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void display() {
        display(root, 0);
    }

    public boolean isEmpty(){
        return root == null;
    }

    private void display(Node p, int level) {
        int i;

        if(p==null) return;

        display(p.rchild, level+1);
        System.out.println();

        for(i =0; i<level; i++)
            System.out.print("    ");
        System.out.println(p.info);

        display(p.lchild, level+1);
    }

    private void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node p) {
        if(p == null) return;
        System.out.print(p.info +" ");
        preOrder(p.lchild);
        preOrder(p.rchild);
    }

    private void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node p) {
        if(p == null) return;
        inOrder(p.lchild);
        System.out.print(p.info +" ");
        inOrder(p.rchild);
    }

    private void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node p) {
        if(p == null) return;
        postOrder(p.lchild);
        postOrder(p.rchild);
        System.out.print(p.info +" ");
    }

    public void createTree() {
        root = new Node(70);
        root.lchild = new Node(40);
        root.rchild = new Node(80);
        root.lchild.lchild = new Node(35);
        root.lchild.rchild = new Node(50);
        root.rchild.lchild = new Node(75);
    }

    public boolean search(int x) {
        Node p = root;

        while(p!= null) {
            if(x < p.info)
                p=p.lchild;
            else if(x> p.info)
                p=p.rchild;
            else
                return true;
        }
        return false;
    }

    public void insert(int x) {
        System.out.println("Inserting node => "+ x);
        Node p = root;
        Node par = null;

        while(p!= null) {
            par = p;
            if(x < p.info)
                p=p.lchild;
            else if(x> p.info)
                p=p.rchild;
            else {
                System.out.println(x+ " is already present in the tree..");
                return;
            }
        }

        Node temp = new Node(x);
        if(par == null)
            root = temp;
        else if(x < par.info)
            par.lchild=temp;
        else if(x > par.info)
            par.rchild = temp;
    }

    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();

        binaryTree.createTree();

        binaryTree.display();

        System.out.println("Preorder Traversal: ");
        binaryTree.preOrder();

        System.out.println("Inorder Traversal: ");
        binaryTree.inOrder();

        System.out.println("Postorder Traversal: ");
        binaryTree.postOrder();

        System.out.println("Iterative search: (35 present in tree?) "+ binaryTree.search(35));

        binaryTree.insert(100);
        binaryTree.insert(44);
        binaryTree.inOrder();

    }


}
