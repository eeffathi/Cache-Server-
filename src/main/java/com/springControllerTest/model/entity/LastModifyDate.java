package com.springControllerTest.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LastModifyDate {
    long dateTimeLong;
    DayDate dayDate;
    DayTime dayTime;
    long time;
    @JsonProperty("null")
    boolean Null;

    @Override
    public String toString() {
        return "LastModifyDate{" +
                "dateTimeLong=" + dateTimeLong +
                ", dayDate=" + dayDate +
                ", dayTime=" + dayTime +
                ", time=" + time +
                ", Null=" + Null +
                '}';
    }

    public long getDateTimeLong() {
        return dateTimeLong;
    }

    public void setDateTimeLong(long dateTimeLong) {
        this.dateTimeLong = dateTimeLong;
    }

    public DayDate getDayDate() {
        return dayDate;
    }

    public void setDayDate(DayDate dayDate) {
        this.dayDate = dayDate;
    }

    public DayTime getDayTime() {
        return dayTime;
    }

    public void setDayTime(DayTime dayTime) {
        this.dayTime = dayTime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isNull() {
        return Null;
    }

    public void setNull(boolean Null) {
        this.Null = Null;
    }

    public LastModifyDate() {
    }

    public LastModifyDate(long dateTimeLong, DayDate dayDate, DayTime dayTime, long time, boolean Null) {
        this.dateTimeLong = dateTimeLong;
        this.dayDate = dayDate;
        this.dayTime = dayTime;
        this.time = time;
        this.Null = Null;
    }
}
