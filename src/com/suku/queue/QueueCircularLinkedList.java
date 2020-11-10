package com.suku.queue;

import com.suku.linked.list.ListNode;

import java.util.NoSuchElementException;

public class QueueCircularLinkedList {

    private ListNode rear;

    public QueueCircularLinkedList() {
        rear = null;
    }

    public boolean isEmpty() {
        return (rear == null);
    }

    public int size() {
        int s = 0;
        if(isEmpty()) return s;
        ListNode p = rear.next;
        do {
            s++;
            p = p.next;
        } while (p != rear.next);
        return s;
    }

    public void enqueue(int x) {
        ListNode p = new ListNode(x);

        if (rear == null) {
            rear = p;
            rear.next = rear;
        }
        else {
            p.next = rear.next;
            rear.next = p;
            rear = p;
        }

    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow.\n");
            throw new NoSuchElementException();
        }
        ListNode temp;

        if(rear.next == rear) {
            temp = rear;
            rear = null;
        } else {
            temp = rear.next;
            rear.next = temp.next;
        }
        return temp.val;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue Underflow.\n");
            throw new NoSuchElementException();
        }

        return rear.next.val;
    }

    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Queue is empty..");
            return;
        }

        System.out.println("Queue is : ");
        ListNode p = rear.next;
        do {
            System.out.print("|" + p.val + "|");
            p = p.next;
        } while(p != rear.next);
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(10);

        queueArray.enqueue(19);
        System.out.println("Dequeue element " + queueArray.dequeue());
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
