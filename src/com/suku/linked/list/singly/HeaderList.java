package com.suku.linked.list.singly;

public class HeaderList {
    private IntegerNode head;
    private int size;

    public HeaderList() {
        head = new IntegerNode(0);
    }

    public void insertAtEnd(int data) {
        IntegerNode temp = new IntegerNode(data);
        IntegerNode p = head;
        while(p.getNext() != null)
            p=p.getNext();

        p.setNext(temp);
        temp.setNext(null);
    }

    public void insertBefore(int value, int x) {
        // find the predecessor of node containing x
        IntegerNode p = head;
        while(p.getNext() != null) {
            if(p.getNext().getValue() == x)
                break;
            p = p.getNext();
        }

        if(p.getNext() == null) {
            System.out.println(x + " is not present in the list.");
        }else {
            IntegerNode temp = new IntegerNode(value);
            temp.setNext(p.getNext());
            p.setNext(temp);
        }
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    public void printList() {
        if(head.getNext() == null) {
            System.out.println("List is empty..");
            return;
        }
        IntegerNode current = head.getNext();
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
        System.out.println();
    }
}
