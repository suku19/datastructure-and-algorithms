package com.suku.queue;

import com.suku.stack.StackArray;

import java.util.NoSuchElementException;

public class QueueArray {
    int queueArray[];
    int front=-1, rear=-1;

    public QueueArray(int maxLength) {
        queueArray = new int[maxLength];
    }

    public boolean isEmpty() {
        return (front == -1 || front == rear+1);
    }

    public boolean isFull() {
        return rear == queueArray.length-1;
    }

    public int size() {
        if(isEmpty())
            return 0;
        else
            return rear-front+1;
    }

    public void enqueue(int x) {
        if(isFull()) {
            System.out.println("Queue Overflow..\n");
            return;
        }

        if(front == -1)
            front++;
        queueArray[++rear] = x;
    }

    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue Underflow.\n");
            throw new NoSuchElementException();
        }

        return queueArray[front++];
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue Underflow.\n");
            throw new NoSuchElementException();
        }

        return queueArray[front];
    }

    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Queue is empty..");
            return;
        }

        System.out.println("Queue is : ");
        for (i = front; i <= rear; i++)
            System.out.print("|" + queueArray[i] + "|");
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(10);

        queueArray.enqueue(19);
        queueArray.enqueue(38);
        queueArray.enqueue(89);
        queueArray.enqueue(10);
        queueArray.enqueue(55);

        queueArray.display();

        System.out.println("Peek element " + queueArray.peek());
        System.out.println("Dequeue element " + queueArray.dequeue());
        System.out.println("Peek element " + queueArray.peek());
        System.out.println("Dequeue element " + queueArray.dequeue());

        System.out.println("Enqueue element 66 =>");
        queueArray.enqueue(66);
        queueArray.display();

        System.out.println("Size = " + queueArray.size());
    }

}
