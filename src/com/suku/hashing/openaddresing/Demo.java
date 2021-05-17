package com.suku.hashing.openaddresing;

public class Demo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        hashTable.insert1(new StudentRecord(44, "sukanta"));
        hashTable.insert1(new StudentRecord(33, "aa"));
        hashTable.insert1(new StudentRecord(69, "bb"));
        hashTable.insert1(new StudentRecord(92, "cc"));
        hashTable.insert1(new StudentRecord(72, "dd"));
        hashTable.insert1(new StudentRecord(5, "ee"));
//        hashTable.insert(new StudentRecord(6, "ff"));
//
        hashTable.displayTable();
//        System.out.println("=============================================");
//        System.out.println("Delete 5");
//        hashTable.delete(5);
//        hashTable.displayTable();
//
//        System.out.println("=============================================");
//        System.out.println("add 8 and 9");
//        hashTable.insert(new StudentRecord(8, "gg"));
//        hashTable.insert(new StudentRecord(9, "hh"));
//        hashTable.displayTable();
//
//        System.out.println("=============================================");
//        System.out.println("Search 33 and 5");
//        System.out.println(hashTable.search(33));
//        System.out.println(hashTable.search(5));
    }
}
