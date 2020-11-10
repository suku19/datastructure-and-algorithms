package com.suku.queue;

import com.suku.linked.list.ListNode;

import java.util.NoSuchElementException;

public class QueueLinkedList {

    private ListNode front, rear;

    public QueueLinkedList() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public int size() {
        int s = 0;
        ListNode p = front;
        while (p != null) {
            s++;
            p = p.next;
        }
        return s;
    }

    public void enqueue(int x) {
        ListNode p = new ListNode(x);

        if (front == null)
            front = p;
        else
            rear.next = p;

        rear = p;

    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow.\n");
            throw new NoSuchElementException();
        }

        int x = front.val;

        front = front.next;

        return x;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue Underflow.\n");
            throw new NoSuchElementException();
        }

        return front.val;
    }

    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Queue is empty..");
            return;
        }

        System.out.println("Queue is : ");
        ListNode p = front;
        while (p!= null) {
            System.out.print("|" + p.val + "|");
            p = p.next;
        }
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
