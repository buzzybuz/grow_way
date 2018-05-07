package ru.innopolis.stc9.servlets.pojo;

public class LessonLog {
    public int leslog_id;
    public int num;
    public int stud_id;
    public Boolean presence;

    public LessonLog(int num, int stud_id, Boolean presence) {
        this.num = num;
        this.stud_id = stud_id;
        this.presence = presence;
    }

    public LessonLog(int leslog_id, int num, int stud_id, Boolean presence) {
        this.leslog_id = leslog_id;
        this.num = num;
        this.stud_id = stud_id;
        this.presence = presence;
    }
}
