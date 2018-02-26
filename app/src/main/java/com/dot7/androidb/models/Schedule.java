package com.dot7.androidb.models;

import java.util.List;

/**
 * Created by legendary on 2/24/18
 */

public class Schedule {
    private int id;
    private String day;
    private List<ScheduleData> data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<ScheduleData> getData() {
        return data;
    }

    public void setData(List<ScheduleData> data) {
        this.data = data;
    }

}
