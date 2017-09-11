package com.tw.model;

import java.util.ArrayList;

//单个的场地类
public class Court {
    //包含场地的id：(A,B,C,D)
    private String courtId;
    //拥有一个链表结构，存储该场地的每条预订或取消记录
    private ArrayList<Record> bookingRecord;
    //记录该场地的所有记录的总价格
    private double price = 0;

    public String getCourtId() {
        return courtId;
    }

    public void setCourtId(String courtId) {
        this.courtId = courtId;
    }

    public ArrayList<Record> getBookingRecord() {
        return bookingRecord;
    }

    public void setBookingRecord(ArrayList<Record> bookingRecord) {
        this.bookingRecord = bookingRecord;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
