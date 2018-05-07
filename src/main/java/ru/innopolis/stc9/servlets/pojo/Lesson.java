package ru.innopolis.stc9.servlets.pojo;

public class Lesson {
    public int num;
    public String date_time;
    public String lesson_data;

    public Lesson(String date_time, String lesson_data) {
        this.date_time = date_time;
        this.lesson_data = lesson_data;
    }

    public Lesson(int num, String date_time, String lesson_data) {
        this.num = num;
        this.date_time = date_time;
        this.lesson_data = lesson_data;
    }
}
