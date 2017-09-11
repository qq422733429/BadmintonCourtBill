package com.tw.model;

import java.util.ArrayList;
import java.util.Stack;

//单个的场地类
public class Court {
    //包含场地的id：(A,B,C,D)
    private String courtId;
    //拥有一个链表结构，存储该场地的每条预订或取消记录
    private ArrayList<Record> bookingRecordList;
    //记录该场地的所有记录的总价格
    private double price = 0;

    public Court(String courtId) {
        this.courtId = courtId;
        this.bookingRecordList = new ArrayList<>();
        this.price = 0;
    }

    public String getCourtId() {
        return courtId;
    }

    public void setCourtId(String courtId) {
        this.courtId = courtId;
    }

    public ArrayList<Record> getBookingRecordList() {
        return bookingRecordList;
    }

    public void setBookingRecordList(ArrayList<Record> bookingRecordList) {
        this.bookingRecordList = bookingRecordList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("场地:");
        sb.append(courtId);
        sb.append("\n");
        for (int i =bookingRecordList.size()-1;i>=0;i-- ) {
            sb.append(bookingRecordList.get(i));
        }
        sb.append("小计：");
        String priceStr = String.valueOf(price);
        String[] temp = priceStr.split("\\.");
        if(temp[1].equals("0")){
            sb.append(temp[0]);
        }else {
            sb.append(price);
        }
        sb.append("元\n");
        return sb.toString();
    }
}
