package com.suku.linked.list.doubly;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedListImpl list = new LinkedListImpl();

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToLast(marySmith);
        list.addToFront(mikeWilson);
        list.printList();

        System.out.println("Remove from front =>");
        list.removeFromFront();
        list.printList();
        System.out.println("Remove from end =>");
        list.removeFromEnd();
        System.out.println("Add before john dao =>");
        list.addBefore(billEnd, johnDoe);
        list.printList();

        System.out.println("Add before non existing employee =>");
        list.addBefore(new Employee("Someone", "Else", 1111), mikeWilson);
        list.printList();

        System.out.println("Reverse the list by changing the links=>");
        list.reverse();
        list.printList();

    }
}
