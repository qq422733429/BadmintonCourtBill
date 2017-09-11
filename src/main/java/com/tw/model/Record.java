package com.tw.model;

public class Record {
    private String userId;
    private TimeBucket bookingTime;
    //获取输入是否为取消订单，false：表示预订，true：表示取消订单
    private boolean isCancel;
    //记录每条记录所对应的价格，包含预订价格和违约金
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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(bookingTime);
        sb.append(" ");
        if (isCancel()) {
            sb.append("违约金 ");
        }
        sb.append(price);
        sb.append("元\n");
        return sb.toString();
    }
}
