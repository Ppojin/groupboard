package com.ppojin.groupboard.domain;

import java.sql.Date;

public class ScheduleVO {
    private int articleID;
    private String title;
    private Date start;
    private Date end;
    private String color;
    private String url;
    private Boolean allDay = true;

    @Override
    public String toString() {
        return "ScheduleVO{" +
                "articleID=" + articleID +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", color='" + color + '\'' +
                ", url='" + url + '\'' +
                ", allDay=" + allDay +
                '}';
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
