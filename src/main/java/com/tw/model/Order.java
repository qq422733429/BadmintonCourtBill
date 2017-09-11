package com.tw.model;

// 根据管理员输入，创建订单类：包含预订用户id，预订时间，场地id，状态：预订or取消
public class Order {
    private String userId;
    private TimeBucket bookingTime;
    private String courtId;
    private boolean isCancel;

    public Order(String userId, TimeBucket bookingTime, String courtId, boolean isCancel) {
        this.userId = userId;
        this.bookingTime = bookingTime;
        this.courtId = courtId;
        this.isCancel = isCancel;
    }

    public String getUserId() {
        return userId;
    }

    public TimeBucket getBookingTime() {
        return bookingTime;
    }

    public String getCourtId() {
        return courtId;
    }

    public boolean isCancel() {
        return isCancel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (isCancel != order.isCancel) return false;
        if (!userId.equals(order.userId)) return false;
        if (!bookingTime.equals(order.bookingTime)) return false;
        return courtId.equals(order.courtId);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + bookingTime.hashCode();
        result = 31 * result + courtId.hashCode();
        result = 31 * result + (isCancel ? 1 : 0);
        return result;
    }
}
