package com.tw.service.input.inputServicelmpl;

import com.tw.model.Order;
import com.tw.model.TimeBucket;
import com.tw.service.input.InputService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputServicelmpl implements InputService {
    @Override
    public Order buildOrders(String ordersInput) {
        TimeBucket timeBucket = new TimeBucket();
        String[] fields = ordersInput.split(" ");
        if (!isLengthVaild(fields) || !isCancelFlagVaild(fields)) {
            return null;
        }
        String[] temp = fields[2].split("~");
        Date startTime = setDateTime(fields[1] + " " + temp[0]);
        Date endTime = setDateTime(fields[1] + " " + temp[1]);
        if (isDateTimeVaild(startTime, endTime)) {
            Order order;
            timeBucket.setStartTime(startTime);
            timeBucket.setEndTime(endTime);
            if (fields.length == 4) {
                order = new Order(fields[0], timeBucket, fields[3], false);
            } else {
                order = new Order(fields[0], timeBucket, fields[3], true);
            }
            return order;
        }else {
            return null;
        }
    }

    public boolean isLengthVaild(String[] fields) {
        if (fields.length < 4 || fields.length > 5) {
            return false;
        }
        return true;
    }

    public boolean isDateTimeVaild(Date startTime, Date endTime) {
        if (startTime == null || endTime == null) {
            return false;
        }
        if (startTime.equals(endTime) || startTime.after(endTime)) {
            return false;
        }
        return true;
    }

    public boolean isCancelFlagVaild(String[] fields) {
        if (fields.length == 5 && (fields[4] == null || !fields[4].equals("C"))) {
            return false;
        }
        return true;
    }

    public Date setDateTime(String timeStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date time;
        try {
            format.setLenient(false);
            time = format.parse(timeStr);
            return time;
        } catch (ParseException e) {
            time = null;
        }
        return time;
    }
}
