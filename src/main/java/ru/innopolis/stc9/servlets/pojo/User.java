package ru.innopolis.stc9.servlets.pojo;

public class User {
    private int stud_id;
    private String name;
    private byte role;

    public User(int stud_id, String name, byte role) {
        this.stud_id = stud_id;
        this.name = name;
        this.role = role;
    }

    public int getStud_id() {
        return stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getRole() {
        return role;
    }

    public void setRole(byte role) {
        this.role = role;
    }
}
