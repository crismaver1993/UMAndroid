package com.dot7.androidb.models;

/**
 * Created by legendary on 2/24/18
 */

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class ScheduleData {

    @Exclude
    transient
    private String day;
    private String topic;
    private String classroom;
    private String starthour;
    private String endhour;
    private String teacher;
    private String semester;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getStarthour() {
        return starthour;
    }

    public void setStarthour(String starthour) {
        this.starthour = starthour;
    }

    public String getEndhour() {
        return endhour;
    }

    public void setEndhour(String endhour) {
        this.endhour = endhour;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSemestre() {
        return semester;
    }

    public void setSemestre(String semestre) {
        this.semester = semestre;
    }

    public String getSemester() {
        return semester;
    }

    @Exclude
    public String getDay() {
        return day;
    }
    @Exclude
    public void setDay(String day) {
        this.day = day;
    }

    public ScheduleData(String day) {
        this.day = day;
    }

    public ScheduleData() {
    }
}