package ru.innopolis.stc9.servlets.pojo;

public class Student {
    public int stud_id;
    public String name;
    public String password;

    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Student(int stud_id, String name, String password) {
        this.stud_id = stud_id;
        this.name = name;
        this.password = password;
    }
}
