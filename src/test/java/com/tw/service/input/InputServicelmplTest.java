package com.tw.service.input;

import com.tw.model.Order;
import com.tw.model.TimeBucket;
import com.tw.service.input.inputServicelmpl.InputServicelmpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by sugarFile on 17/9/11.
 */
public class InputServicelmplTest {
    @Test
    public void inputInlleagLengthShouldBeInvaild() {
        InputService inputService = new InputServicelmpl();
        String inStr = "akdkafjdfal sjakf slk";
        Order acturl = null;
        assertEquals(inputService.isLengthVaild(inStr), acturl);
    }

    @Test
    public void inputInvaildDateShouldBeRejected() {
        InputService inputService = new InputServicelmpl();
        String inStr = "U001 2017/09/08 22:00~23:00 A";
        Order acturl = null;
        assertEquals(inputService.isDateTimeVaild(inStr), acturl);
    }

    @Test
    public void inputInvaildTimeShouldBeRejected() {
        InputService inputService = new InputServicelmpl();
        String inStr = "U001 2017-09-11 22:00~21:00 A";
        Order acturl = null;
        assertEquals(inputService.isDateTimeVaild(inStr), acturl);
    }

    @Test
    public void inputInvaildCancelFlagShouldBeInvaild() {
        InputService inputService = new InputServicelmpl();
        String inStr = "U001 2017/09/08 22:00~23:00 A G";
        Order acturl = null;
        assertEquals(inputService.isCancelFlagVaild(inStr), acturl);
    }

    @Test
    public void inputVaildStringShouldBeCorrect() throws ParseException {
        InputServicelmpl inputServicelmpl = new InputServicelmpl();
        String inStr = "U001 2017-09-20 22:00~23:00 A";
        String UID = "U001";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date start = format.parse("2017-09-20 22:00");
        Date end = format.parse("2017-09-20 23:00");
        TimeBucket timeBucket = new TimeBucket();
        timeBucket.setStartTime(start);
        timeBucket.setEndTime(end);
        Order actual = new Order(UID,timeBucket,"A",false);
        assertEquals(inputServicelmpl.buildOrders(inStr),actual);
    }

}