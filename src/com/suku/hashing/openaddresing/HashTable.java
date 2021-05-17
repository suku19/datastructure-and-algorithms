package com.suku.hashing.openaddresing;

public class HashTable {
    private StudentRecord[] array;
    private int m; // size of the array
    int n;         // number of records

    public HashTable() {
        this(11);
    }

    public HashTable(int tableSize) {
        m = tableSize;
        array = new StudentRecord[m];
        n = 0;
    }

    int hash(int key) {
        return (key%m);
    }

    public void insert1(StudentRecord newRec) {
        if(n >= m/2) {
            rehash(nextPrime(2*m));
            System.out.println("new table size is : "+m);
        }
        insert(newRec);
    }

    private void rehash(int newSize) {
        HashTable temp = new HashTable(newSize);
        for (int i = 0; i < m; i++) {
            //insert record if empty or key is -1
            if (array[i] != null && array[i].getStudentId() != -1) {
                temp.insert(array[i]);
                temp.n++;
            }
        }
        array = temp.array;
        m = newSize;
    }

    private int nextPrime(int n) {
        while (!isPrime(n))
            n++;
        return n;
    }

    private boolean isPrime(int x) {
        for (int i = 2; i<x; i++) {
            if (x%i == 0)
                return false;
        }
        return true;
    }

    public void insert(StudentRecord newRecord) {
        int key = newRecord.getStudentId();
        int hash = hash(key);

        int location = hash;

        for(int i=1; i<m; i++) {
            //insert record if empty or key is -1
            if(array[location] == null || array[location].getStudentId() == -1) {
                array[location] = newRecord;
                n++;
                return;
            }
            // handle duplicate key
            if(array[location].getStudentId() == key) {
                throw new UnsupportedOperationException("Duplicate Key");
            }

            //new hash function
            location = (hash+i) % m;
        }
        System.out.println("Table is full.. Record can not be inserted..");
    }

    public StudentRecord search(int key) {
        int hash = hash(key);
        int location = hash;

        for(int i=1; i<m; i++) {
            if (array[location] == null) {
                return null;
            }

            if(array[location].getStudentId() == key) {
                return array[location];
            }
            location = (hash+i) % m;
        }
        return null;
    }

    public void displayTable() {
        for (int i=0; i<m; i++) {
            System.out.println("[" +i+"] ---->");
            if(array[i] != null && array[i].getStudentId() != -1) {
                System.out.println(array[i]);
            } else {
                System.out.println("____");
            }
        }
    }

    public StudentRecord delete(int key) {
        int h = hash(key);
        int location = h;
        for(int i=1; i<m; i++) {
            if (array[location] == null) {
                return null;
            }

            if(array[location].getStudentId() == key) {
                StudentRecord temp = array[location];
                array[location].setStudentId(-1);
                n--;
                return temp;
            }

            location = (h+i)%m;
        }
        return null;
    }


}
