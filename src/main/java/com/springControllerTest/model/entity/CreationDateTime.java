package com.springControllerTest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreationDateTime {
    long dateTimeLong;
    DayDate dayDate;
    DayTime dayTime;
    long time;
    @JsonProperty("null")
    boolean Null;

    @Override
    public String toString() {
        return "CreationDateTime{" +
                "dateTimeLong=" + dateTimeLong +
                ", dayDate=" + dayDate +
                ", dayTime=" + dayTime +
                ", time=" + time +
                ", Null=" + Null +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreationDateTime that = (CreationDateTime) o;
        return dateTimeLong == that.dateTimeLong &&
                time == that.time &&
                Null == that.Null &&
                Objects.equals(dayDate, that.dayDate) &&
                Objects.equals(dayTime, that.dayTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTimeLong, dayDate, dayTime, time, Null);
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

    public void setNull(boolean aNull) {
        Null = aNull;
    }

    public CreationDateTime() {
    }

    public CreationDateTime(long dateTimeLong, DayDate dayDate, DayTime dayTime, long time, boolean aNull) {
        this.dateTimeLong = dateTimeLong;
        this.dayDate = dayDate;
        this.dayTime = dayTime;
        this.time = time;
        Null = aNull;
    }
}
