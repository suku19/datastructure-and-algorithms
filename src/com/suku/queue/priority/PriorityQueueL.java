package com.suku.queue.priority;

import com.suku.queue.QueueArray;

import java.util.NoSuchElementException;

public class PriorityQueueL {
    private Node front;

    public PriorityQueueL() {
        front = null;
    }

    public boolean isEmpty() {
        return (front==null);
    }

    public void insert(int x, int priority) {
        Node temp = new Node(x,priority), p;

        if(isEmpty() || priority < front.priority) {
            temp.link = front;
            front = temp;
        } else {
            p = front;
            while (p.link !=null && p.link.priority <= priority) {
                p = p.link;
            }

            temp.link = p.link;
            p.link = temp;
        }
    }

    public int delete() {
        if (isEmpty()) {
            System.out.println("Queue Underflow.\n");
            throw new NoSuchElementException();
        }

        int x = front.info;
        front = front.link;
        return x;
    }

    public void display() {
        Node p = front;

        if (isEmpty()) {
            System.out.println("Queue is empty..");
            return;
        }

        System.out.println("Queue is : ");
        System.out.println("Element    Priority");

        while (p != null) {
            System.out.println(p.info + "         "+p.priority);
            p = p.link;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueueL queueArray = new PriorityQueueL();

        queueArray.insert(19, 10);
        queueArray.insert(38, 5);
        queueArray.insert(89, 8);
        queueArray.insert(10, 1);
        queueArray.insert(55, 3);

        queueArray.display();

        System.out.println("Delete element " + queueArray.delete());
        System.out.println("Delete element " + queueArray.delete());

        System.out.println("Insert element 66 =>");
        queueArray.insert(66,9);
        queueArray.display();
    }

}
