package com.suku.hashing;

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class MyHashMap {
    Node [] buckets;

    public MyHashMap() {
        this(100);
    }
    public MyHashMap(int size) {
        this.buckets = new Node[size];
    }

    public void put(int key, int value) {
        Node newNode = new Node(key,value);

        int hash = getHash(key);

        if(buckets[hash] == null)
            buckets[hash] = newNode;
        else {
            Node temp = buckets[hash];

            //
            while(temp.next != null) {
                if(temp.key == key) {
                    temp.val = value;
                    break;
                }
                temp= temp.next;
            }
            if(temp.key == key) {
                temp.val = value;
                return;
            }

            temp.next = newNode;
        }

    }

    private int getHash(int key) {
        return key % buckets.length;
    }

    public void remove(int key) {
        int hash = getHash(key);

        if(buckets[hash] == null)
            return;

        Node prev=null, prevref=null, current = buckets[hash];

        while(current != null) {
            if(current.key == key) {
                prevref = prev;
                break;
            }
            prev = current;
            current = current.next;
        }

        if(prevref == null)
            return;
        else
            prev.next = prev.next.next;
    }

    public int get(int key) {
        int hash = getHash(key);

        if(buckets[hash] == null)
            return -1;

        Node temp = buckets[hash];
        while(temp != null) {
            if(temp.key == key) {
                return temp.val;
            }
            temp = temp.next;
        }
        return -1;
    }


    class Node{
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,1);
        myHashMap.put(101,101);
        myHashMap.put(201,201);
        myHashMap.put(301,301);

        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(101));
        System.out.println(myHashMap.get(201));
        myHashMap.remove(201);
        System.out.println(myHashMap.get(201));

    }
}
