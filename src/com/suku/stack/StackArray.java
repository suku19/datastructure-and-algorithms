package com.suku.stack;

import java.util.EmptyStackException;

public class StackArray {

    private int[] stackArray;
    private int top;

    public StackArray() {
        stackArray = new int[10];
        top = -1;
    }

    public StackArray(int maxSize) {
        stackArray = new int[maxSize];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == stackArray.length - 1);
    }

    //push operation
    public void push(int n) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        top = top + 1;
        stackArray[top] = n;
    }

    //pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            throw new EmptyStackException();
        }
        int x = stackArray[top];
        top = top - 1;
        return x;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Stack is empty..");
            return;
        }

        System.out.println("Stack is : ");
        for (i = top; i >= 0; i--)
            System.out.println("|" + stackArray[i] + "|");

        System.out.println("___");
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(10);

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
