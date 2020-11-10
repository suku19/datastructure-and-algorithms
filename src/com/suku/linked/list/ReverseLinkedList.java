package com.suku.linked.list;

import java.util.Random;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null, next;
        ListNode p = head;

        while (p != null) {
            next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        head = prev;
        return head;
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
        ListNode listNode = generateLinkedList(5);
        printList(listNode);
        listNode = reverseList(listNode);
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