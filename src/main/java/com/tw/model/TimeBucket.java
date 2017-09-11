package com.tw.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sugarFile on 17/9/11.
 */
public class TimeBucket {
    private Date startTime;
    private Date endTime;
    private int dayOfWeek;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        this.dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeBucket that = (TimeBucket) o;

        if (dayOfWeek != that.dayOfWeek) return false;
        if (!startTime.equals(that.startTime)) return false;
        return endTime.equals(that.endTime);
    }

    @Override
    public int hashCode() {
        int result = startTime.hashCode();
        result = 31 * result + endTime.hashCode();
        result = 31 * result + dayOfWeek;
        return result;
    }
}
