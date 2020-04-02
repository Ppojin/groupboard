package com.ppojin.groupboard.domain;

import java.util.List;

public class ScheduleListVO {
    private List<ScheduleVO> scheduleVOList;

    public List<ScheduleVO> getScheduleVOList() {
        return scheduleVOList;
    }

    public void setScheduleVOList(List<ScheduleVO> scheduleVOList) {
        this.scheduleVOList = scheduleVOList;
    }

    @Override
    public String toString() {
        return "ScheduleListVO{" +
                "scheduleVOList=" + scheduleVOList +
                '}';
    }
}
