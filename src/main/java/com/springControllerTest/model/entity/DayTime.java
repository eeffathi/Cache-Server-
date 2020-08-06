package com.springControllerTest.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DayTime {
    long dayTime;
    long hour;
    long minute;
    long second;

    public long getDayTime() {
        return dayTime;
    }

    @Override
    public String toString() {
        return "DayTime{" +
                "dayTime=" + dayTime +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }

    public void setDayTime(long dayTime) {
        this.dayTime = dayTime;
    }

    public long getHour() {
        return hour;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }

    public long getMinute() {
        return minute;
    }

    public void setMinute(long minute) {
        this.minute = minute;
    }

    public long getSecond() {
        return second;
    }

    public void setSecond(long second) {
        this.second = second;
    }

    public DayTime() {
    }

    public DayTime(long dayTime, long hour, long minute, long second) {
        this.dayTime = dayTime;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
}
