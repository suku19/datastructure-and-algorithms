package com.suku.queue;

import com.suku.linked.list.ListNode;

import java.util.NoSuchElementException;

public class QueueCircularArray {
    private int[] queueArray;

    private int front;
    private int rear;

    public QueueCircularArray(int maxSize) {
        queueArray = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return (front != -1);
    }

    public boolean isFull() {
        return ((front == 0 && rear == queueArray.length-1) || front == rear+1);
    }

    public int size() {
        if(isEmpty()) return 0;
        if(isFull()) return  queueArray.length;
        int size =0;
        int i = front;
        if(front<= rear) {
            while(i <= rear) {
                i++;
                size++;
            }
        } else {
            while(i <= queueArray.length-1) {
                i++;
                size++;
            }
            i=0;
            while(i <= rear) {
                i++;
                size++;
            }
        }

        return size;
    }

    public void enqueue(int x) {
        if(isFull()) {
            System.out.println("Queue Overflow..\n");
            return;
        }

        if(front == -1) front =0;
        if(rear == queueArray.length-1) rear =0;
        else rear++;

        queueArray[rear] = x;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow.\n");
            throw new NoSuchElementException();
        }
        int x = queueArray[front];
        if(front == rear) { /*queue has only one element then set front and rear to -1*/
            front = -1;
            rear = -1;
        } else if(front == queueArray.length-1)
            front =0;
        else
            front++;
        return x;

    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue Underflow.\n");
            throw new NoSuchElementException();
        }

        return queueArray[front];
    }

    public void display() {
        int i = front;
        if (isEmpty()) {
            System.out.println("Queue is empty..");
            return;
        }

        System.out.println("Queue is : ");

        if(front<= rear) {
            while(i <= rear) {
                System.out.print("|" + queueArray[i++] + "|");
            }
        } else {
            while(i <= queueArray.length-1)
                System.out.print("|" + queueArray[i++] + "|");

            i=0;
            while(i <= rear)
                System.out.print("|" + queueArray[i++] + "|");
        }

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
