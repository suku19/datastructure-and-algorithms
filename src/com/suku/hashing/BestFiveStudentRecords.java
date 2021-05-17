package com.suku.hashing;


import java.util.*;

public class BestFiveStudentRecords {

    static class Record {
        public int id, score;

        public Record(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public static Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, TreeSet<Integer>> store = new HashMap<>();
        Map<Integer, Double> result = new HashMap<>();
        for(Record rec: results) {
            TreeSet<Integer> helperSet = store.getOrDefault(rec.id, new TreeSet<Integer>());
            helperSet.add(rec.score);
            if(helperSet.size() > 5) {
                helperSet.pollFirst();
            }
            store.put(rec.id, helperSet);
        }

        store.forEach((k,v) -> {
            Double avg = v.stream().mapToInt(x->x).average().getAsDouble();
            result.put(k,avg);
        });

        return result;
    }
    public static void main(String[] args) {
        Record r11 = new Record(1, 90);
        Record r12 = new Record(1, 95);
        Record r13 = new Record(1, 96);
        Record r14 = new Record(1, 97);
        Record r15 = new Record(1, 93);
        Record r16 = new Record(1, 89);
        Record r17 = new Record(1, 76);
        Record r18 = new Record(1, 99);

        Record r21 = new Record(2, 90);
        Record r22 = new Record(2, 95);
        Record r23 = new Record(2, 96);
        Record r24 = new Record(2, 97);
        Record r25 = new Record(2, 93);

        Record[] results = new Record[]{r11, r12, r13, r14, r15, r16, r17, r18, r21, r22, r23, r24, r25};

        Map<Integer, Double> highFive = highFive(results);

        System.out.println(highFive);
    }
}
