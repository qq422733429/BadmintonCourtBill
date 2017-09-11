package com.tw.service.process.ProcessServicelmpl;

import com.tw.model.Court;
import com.tw.model.Courts;
import com.tw.model.Order;
import com.tw.model.Record;
import com.tw.service.process.ProcessService;

import java.util.ArrayList;

public class ProcessServicelmpl implements ProcessService {
    @Override
    public int calculateAllKindsOfBill(Courts courts, Order order) {
        Court court = courts.findCourtById(order.getCourtId());
        ArrayList<Record> bookingRecord = court.getBookingRecordList();
        if (order.isCancel()) {
            return calculatePenalty(order, bookingRecord, court);
        }else {
            return calculateBookingBill(order, bookingRecord, court);
        }
    }

    private int calculateBookingBill(Order order, ArrayList<Record> bookingRecord, Court court) {
        if (isBooked(order, bookingRecord)) {
            return 1;
        } else {
            Record record = new Record();
            record.setUserId(order.getUserId());
            record.setCancel(false);
            record.setBookingTime(order.getBookingTime());
            int start = order.getBookingTime().getStartTime().getHours();
            int end = order.getBookingTime().getEndTime().getHours();
            int weekday = order.getBookingTime().getDayOfWeek();
            if (weekday == 1 || weekday == 7) {
                for (int i = start; i < end; i++) {
                    record.setPrice(record.getPrice() + calculateHoursPriceWeekend(i));
                }
            }else {
                for (int i = start; i < end; i++) {
                    record.setPrice(record.getPrice() + calculateHoursPriceWeekday(i));
                }
            }
            court.getBookingRecordList().add(record);
            court.setPrice(court.getPrice() + record.getPrice());
            return 0;
        }
    }

    private int calculatePenalty(Order order, ArrayList<Record> bookingRecordList, Court court) {
        for (Record item : bookingRecordList) {
            if (!isCanceled(item, order)) {
                bookingRecordList.remove(item);
                court.setPrice(court.getPrice() - item.getPrice());
                item.setCancel(true);
                int week = item.getBookingTime().getDayOfWeek();
                if (week == 1 || week == 7) {
                    item.setPrice(item.getPrice() * 0.25);
                } else {
                    item.setPrice(item.getPrice() * 0.5);
                }
                court.setPrice(court.getPrice() + item.getPrice());
                court.getBookingRecordList().add(item);
                return 0;
            }else {
                continue;
            }
        }
        return 2;
    }

    private boolean isBooked(Order order, ArrayList<Record> bookingRecord) {
        boolean flag = true;
        for (Record item : bookingRecord) {
            if (item.isCancel()) {
                continue;
            }
            if (item.getBookingTime().getStartTime().getDate() == order.getBookingTime().getStartTime().getDate()) {
                int start = order.getBookingTime().getStartTime().getHours();
                int end = order.getBookingTime().getEndTime().getHours();
                int recordStart = item.getBookingTime().getStartTime().getHours();
                int recordEnd = item.getBookingTime().getEndTime().getHours();
                for (int i = start; i < end; i++) {
                    if (i >= recordStart && i < recordEnd) {
                        flag = false;
                        break;
                    }
                }
            }else {
                continue;
            }
            if (!flag){
                return true;
            }
        }
        return false;
    }

    public boolean isCanceled(Record item, Order order) {
        if (order.getUserId().equals(item.getUserId()) && order.getBookingTime().equals(item.getBookingTime()) && !item.isCancel() ) {
            return false;
        }
        return true;
    }

    private double calculateHoursPriceWeekday(int hours){
        if(hours<12){
            return 30;
        }
        if (hours<18){
            return 50;
        }
        if (hours<20){
            return 80;
        }
        if (hours<22){
            return 60;
        }
        throw new IllegalArgumentException();
    }

    private double calculateHoursPriceWeekend(int hours) {
        if(hours<12){
            return 40;
        }
        if (hours<18){
            return 50;
        }
        if (hours<22){
            return 60;
        }
        throw new IllegalArgumentException();
    }
}
