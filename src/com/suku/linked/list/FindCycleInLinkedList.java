package com.suku.linked.list;

import java.util.Random;

public class FindCycleInLinkedList {

    //Floyd's cycle detection algorithm

    public static boolean hasCycle(ListNode head) {
        if( head == null || head.next == null) return false;
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
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

    public static void createCyclic(ListNode head) {
        System.out.println("Creating cyclic Node...> ");
        ListNode current = head, cyclicNode = null;
        int counter = 0;
        while (current.next != null) {
            if(counter== 3) {
                cyclicNode = current;
            }
            current = current.next;
            counter++;
        }
        current.next = cyclicNode;
    }

    public static void main(String[] args) {
        ListNode listNode = generateLinkedList(5);
        printList(listNode);
        System.out.println("Has cycle => "+ hasCycle(listNode));
        createCyclic(listNode);
        System.out.println("Has cycle => "+ hasCycle(listNode));

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