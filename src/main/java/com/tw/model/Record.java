package com.tw.model;

/**
 * Created by sugarFile on 17/9/11.
 */
public class Record {
    private String userId;
    private TimeBucket bookingTime;
    private boolean isCancel;
    private double price;

    public Record() {
        this.isCancel = false;
        this.price = 0;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public TimeBucket getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(TimeBucket bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public void setCancel(boolean cancel) {
        isCancel = cancel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (isCancel != record.isCancel) return false;
        if (Double.compare(record.price, price) != 0) return false;
        if (!userId.equals(record.userId)) return false;
        return bookingTime.equals(record.bookingTime);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userId.hashCode();
        result = 31 * result + bookingTime.hashCode();
        result = 31 * result + (isCancel ? 1 : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
