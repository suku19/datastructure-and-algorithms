package com.suku.hashing.openaddresing;

public class StudentRecord {
    private int studentId;
    private String name;

    public StudentRecord(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentRecord{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }
}
