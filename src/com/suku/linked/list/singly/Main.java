package com.suku.linked.list.singly;

public class Main {

    public static void main(String[] args) {

        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        IntegerLinkedList list = new IntegerLinkedList();
        list.insertSorted(three);
        list.printList();
        list.insertSorted(two);
        list.printList();
        list.insertSorted(one);
        list.printList();
        System.out.println("Insert at End =>");
        list.insertAtEnd(four);
        list.printList();

        System.out.println();
        System.out.println("Header List =>");
        HeaderList headerList = new HeaderList();
        headerList.insertAtEnd(one);
        headerList.insertAtEnd(three);
        headerList.insertAtEnd(four);
        headerList.insertAtEnd(two);
        headerList.printList();

        System.out.println("Header List - insert 5 before node whose value is three=>");
        headerList.insertBefore(5,3);
        headerList.printList();

    }
}
