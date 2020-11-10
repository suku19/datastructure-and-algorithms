package com.suku.linked.list;

import java.util.Random;

public class MergingTwoSortedLists {
    //by creating a new linked list
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode startM;
        /* find out the start node of new list*/
        if(l1.val <= l2.val) {
            startM = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            startM = new ListNode(l2.val);
            l2 = l2.next;
        }

        ListNode pM = startM;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                pM.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                pM.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            pM = pM.next;
        }

        /*If second list is finished and elements left in the first list*/
        while(l1 != null) {
            pM.next = new ListNode(l1.val);
            l1 = l1.next;
            pM = pM.next;
        }
        /*If first list is finished and elements left in the second list*/
        while(l2 != null) {
            pM.next = new ListNode(l2.val);
            l2 = l2.next;
            pM = pM.next;
        }
        return startM;
    }

    //bubble sort by exchanging the data
    public static void bubbleSortExData(ListNode head) {
        ListNode end, p, q;

        for(end = null; end != head.next; end = p) {
            for(p = head; p.next != end; p= p.next) {
                q = p.next;
                if(p.val > q.val) {
                    int temp = p.val;
                    p.val = q.val;
                    q.val = temp;
                }
            }
        }
    }

    //bubble sort by exchanging the links
    public static void bubbleSortExLink(ListNode head) {
        ListNode end, p, q, temp, r;

        for(end = null; end != head.next; end = p) {
            for (r = p = head; p.next != end; r=p, p = p.next) {
                q = p.next;
                if(p.val > q.val) {
                    p.next = q.next;
                    q.next = p;
                    if(p != head) {
                        r.next = q;
                    } else {
                        head = q;
                    }

                    temp = p;
                    p = q;
                    q = temp;
                }
            }
        }
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print("[" + current + "]");
            System.out.print(" ->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode l1 = generateLinkedList(3);
        System.out.println("Sorted list by exchanging data..>");
        bubbleSortExData(l1);
        printList(l1);

        ListNode l2 = generateLinkedList(5);
        System.out.println("Sorted list by exchanging data");
        bubbleSortExData(l2);
        printList(l2);

        System.out.println("Merge of two sorted list --> ");
        ListNode listNode = mergeTwoLists(l1, l2);
        printList(listNode);
    }

    public static ListNode generateLinkedList(int len) {
        Random rand = new Random();
        ListNode head = new ListNode(rand.nextInt(10) + 1);
        ListNode current = head;
        for (int i = 0; i < len - 1; i++) {
            current.next = new ListNode(rand.nextInt(10) + 1);
            current = current.next;
        }
        return head;
    }
}