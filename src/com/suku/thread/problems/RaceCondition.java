package com.suku.thread.problems;

import java.util.Hashtable;

/**
 * If you call getInstance() method from two thread simultaneously its possible that while one thread is initializing
 * singleton after null check, another thread sees the value of _instance reference variable as null
 * (quite possible in java) especially if your object takes longer time to initialize and enters into a critical
 * section which eventually results in getInstance() returning two separate instances of Singleton.
 */
class Singleton {
    private static Singleton _INSTANCE;

    public static Singleton getInstance() {
        if (_INSTANCE == null) {
            synchronized (Singleton.class) { //double checked locking - because second check of Singleton instance with lock
                if (_INSTANCE == null) {
                    _INSTANCE = new Singleton();
                }
            }
        }
        return _INSTANCE;
    }

}

public class RaceCondition {
    /*1. Check and Act" race condition pattern*/

    /*
    Without synchronized its possible that while one thread is initializing singleton after null check,
    another thread sees the value of _instance reference variable as null (quite possible in java) especially
    if your object takes longer time to initialize and enters into a critical section which eventually
    results in getInstance() returning two separate instances of Singleton.
    */

    Singleton singleton = Singleton.getInstance();

    /*2. read-modify-update race conditions*/

    /*
    The read-modify-update pattern also comes due to improper synchronization of non-atomic
    operations or a combination of two individual atomic operations which is not atomic
    together e.g. put if absent scenario. consider below code
    */

    Hashtable hashtable = new Hashtable();
    public void checkAndAdd(String key, String value) {
        if(!hashtable.contains(key)){
            hashtable.put(key,value);
        }
    }



}
