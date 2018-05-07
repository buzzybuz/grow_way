package ru.innopolis.stc9.servlets.pojo;

public class WorkFile {
    public int file_id;
    public int worklog_id;
    public String file_path;

    public WorkFile(int worklog_id, String file_path) {
        this.worklog_id = worklog_id;
        this.file_path = file_path;
    }

    public WorkFile(int file_id, int worklog_id, String file_path) {
        this.file_id = file_id;
        this.worklog_id = worklog_id;
        this.file_path = file_path;
    }
}
