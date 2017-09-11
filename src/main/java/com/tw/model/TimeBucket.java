package com.tw.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeBucket {
    //定义预订场地的开始时间和结束时间，类型为Date
    private Date startTime;
    private Date endTime;
    //根据预订的时间，获取时间所对应的具体星期日期：1：表示周日，2~6：表示周一~周五，7：表示周日
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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(startTime);
        int startHour = startTime.getHours();
        int endHour = endTime.getHours();
        sb.append(date);
        sb.append(" ");
        if (startHour < 10) {
            sb.append("0");
        }
        sb.append(startHour);
        sb.append(":00~");
        if (endHour < 10) {
            sb.append("0");
        }
        sb.append(endHour);
        sb.append(":00");
        return sb.toString();
    }
}
