package com.springControllerTest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DayDate {
    long dateTimeLong;
    long year;
    long month;
    long date;
    boolean valid;
    long day;

    public DayDate(long dateTimeLong, long year, long month, long date, boolean valid, long day) {
        this.dateTimeLong = dateTimeLong;
        this.year = year;
        this.month = month;
        this.date = date;
        this.valid = valid;
        this.day = day;
    }

    public DayDate() {
    }

    @Override
    public String toString() {
        return "DayDate{" +
                "dateTimeLong=" + dateTimeLong +
                ", year=" + year +
                ", month=" + month +
                ", date=" + date +
                ", valid=" + valid +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayDate dayDate = (DayDate) o;
        return dateTimeLong == dayDate.dateTimeLong &&
                year == dayDate.year &&
                month == dayDate.month &&
                date == dayDate.date &&
                valid == dayDate.valid &&
                day == dayDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTimeLong, year, month, date, valid, day);
    }

    public long getDateTimeLong() {
        return dateTimeLong;
    }

    public void setDateTimeLong(long dateTimeLong) {
        this.dateTimeLong = dateTimeLong;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getMonth() {
        return month;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }
}
