package ru.innopolis.stc9.servlets.pojo;

import java.util.Date;

public class Lesson {
    private int num;
    private Date date_time;
    private String lesson_data;

    public Lesson(int num, Date date_time, String lesson_data) {
        this.num = num;
        this.date_time = date_time;
        this.lesson_data = lesson_data;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public String getLesson_data() {
        return lesson_data;
    }

    public void setLesson_data(String lesson_data) {
        this.lesson_data = lesson_data;
    }
}
