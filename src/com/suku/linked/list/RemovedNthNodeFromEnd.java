package com.suku.linked.list;

import java.util.Random;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemovedNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumyHead = new ListNode(0);
        dumyHead.next = head;

        ListNode fast = dumyHead, slow = dumyHead;

        for (int i = 1; i <= (n + 1); i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;


        return dumyHead.next;
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
        ListNode listNode = generateLinkedList(1);
        printList(listNode);
        listNode = removeNthFromEnd(listNode, 1);
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
