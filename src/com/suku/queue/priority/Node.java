package com.suku.queue.priority;

public class Node {
    public int priority;
    public int info;
    public Node link;

    public Node(int x, int pr) {
        info =x;
        priority = pr;
        link = null;
    }
}
