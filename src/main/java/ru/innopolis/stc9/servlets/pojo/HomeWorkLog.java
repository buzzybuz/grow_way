package ru.innopolis.stc9.servlets.pojo;

public class HomeWorkLog {
    public int worklog_id;
    public int work_id;
    public int stud_id;
    public byte progress;
    public byte assessment;

    public HomeWorkLog(int work_id, int stud_id, byte progress, byte assessment) {
        this.work_id = work_id;
        this.stud_id = stud_id;
        this.progress = progress;
        this.assessment = assessment;
    }

    public HomeWorkLog(int worklog_id, int work_id, int stud_id, byte progress, byte assessment) {
        this.worklog_id = worklog_id;
        this.work_id = work_id;
        this.stud_id = stud_id;
        this.progress = progress;
        this.assessment = assessment;
    }
}
