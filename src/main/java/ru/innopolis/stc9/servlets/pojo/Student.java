package ru.innopolis.stc9.servlets.pojo;

public class Student {
    public int stud_id;
    public String name;
    public String password;
    public byte role;

    public Student(int stud_id, String name, String password, byte role) {
        this.stud_id = stud_id;
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
