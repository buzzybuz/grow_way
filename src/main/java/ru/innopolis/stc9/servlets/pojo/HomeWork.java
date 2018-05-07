package ru.innopolis.stc9.servlets.pojo;

import java.sql.Timestamp;

public class HomeWork {
    public int work_id;
    public int num;
    public String task_text;
    public Timestamp deadline;

    public HomeWork(int num, String task_text, Timestamp deadline) {
        this.num = num;
        this.task_text = task_text;
        this.deadline = deadline;
    }

    public HomeWork(int work_id, int num, String task_text, Timestamp deadline) {
        this.work_id = work_id;
        this.num = num;
        this.task_text = task_text;
        this.deadline = deadline;
    }
}
