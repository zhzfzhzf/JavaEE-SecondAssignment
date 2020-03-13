package com.java.code.model;

import java.util.Date;

public class Student_Homework {
    private int id;
    private int studentid;
    private int homework;
    private String homeworkTitle;
    private String homeworkContent;
    private Date createTime;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public int getStudentid() {
        return studentid;
    }

    public int getHomework() {
        return homework;
    }

    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public String getHomeworkContent() {
        return homeworkContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public void setHomework(int homework) {
        this.homework = homework;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    public void setHomeworkContent(String homeworkContent) {
        this.homeworkContent = homeworkContent;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
