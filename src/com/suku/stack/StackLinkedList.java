package com.suku.stack;

import com.suku.linked.list.ListNode;

import java.util.EmptyStackException;

public class StackLinkedList {

    private ListNode top;
    int size;

    public StackLinkedList() {
        top = null;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    //push operation
    public void push(int n) {
        ListNode node  = new ListNode(n);
        node.next = top;
        top = node;
        size++;
    }

    //pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow\n");
            throw new EmptyStackException();
        }
        int x = top.val;
        top = top.next;
        size--;
        return x;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow\n");
            throw new EmptyStackException();
        }
        return top.val;
    }

    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Stack is empty..");
            return;
        }

        System.out.println("Stack is : ");
        ListNode current = top;
        while(current != null) {
            System.out.println("|" + current.val + "|");
            current = current.next;
        }

        System.out.println("___");
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        stack.push(19);
        stack.push(38);
        stack.push(89);
        stack.push(10);
        stack.push(55);

        stack.display();

        System.out.println("Peek element " + stack.peek());
        System.out.println("Pop element " + stack.pop());
        System.out.println("Peek element " + stack.peek());
        System.out.println("Pop element " + stack.pop());

        System.out.println("Push element 66 =>");
        stack.push(66);

        stack.display();

        System.out.println("Size = " + stack.size());
    }


}
