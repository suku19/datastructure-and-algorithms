package com.suku.linked.list.doubly;

public class LinkedListImpl {
    private Node head;
    private Node tail;
    private int size;

    public void addToFront(Object data) {
        Node node = new Node(data);
        if(head == null) {
            tail = node;
        } else {
            node.setNext(head);
            head.setPrevious(node);
        }
        head = node;
        size++;
    }

    public Node removeFromFront() {
        Node removedNode = head;

        if(isEmpty()) {
            return null;
        }

        if(head.getNext() == null) {
            tail = null;
        }else {
            head.getNext().setPrevious(null);
        }
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void addToLast(Object data) {
        Node node = new Node(data);

        if(tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public Node removeFromEnd() {
        if (isEmpty()) return null;
        Node removedNode = tail;

        if(tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public boolean addBefore (Object newData, Object existingData) {
        if(isEmpty()) return false;
        Node newNode = new Node(newData);
        Node existingNode = new Node(existingData);

        Node current = head;
        while(current != null && !current.getData().equals(existingData)) {
            current = current.getNext();
        }

        if(current == null) {
            return false;
        }

        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);
        current.setPrevious(newNode);

        if(head == current) {
            head = newNode;
        } else {
            current.getPrevious().setNext(newNode);
        }
        size++;

        return true;
    }

    public void reverse() {
        if(isEmpty()) return;

        if(head.getNext() == null) return;

        Node p1 = head;
        Node p2 = head.getNext();

        p1.setNext(null);
        p1.setPrevious(p2);

        while(p2 != null) {
            p2.setPrevious(p2.getNext());
            p2.setNext(p1);
            p1=p2;
            p2= p2.getPrevious();
        }
        head = p1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node current = head;

        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}

class Node {
    private Object data;
    private Node next;
    private Node previous;

    Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public String toString() {
        return data.toString();
    }
}
