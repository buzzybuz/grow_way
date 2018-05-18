package ru.innopolis.stc9.servlets.pojo;

public class User {
    public int stud_id;
    public String name;
    public byte role;

    public User(int stud_id, String name, byte role) {
        this.stud_id = stud_id;
        this.name = name;
        this.role = role;
    }
}
