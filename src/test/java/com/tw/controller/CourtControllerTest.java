package com.tw.controller;

import com.tw.controller.controllerlmpl.Controllerlmpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourtControllerTest {
    Controller controller;
    @Before
    public void init(){
        controller=new Controllerlmpl();
    }


    @Test
    public void inputInvaildStringShouldbeInvaild() {
        String input = "abcdefghijklmnopqrst1234567890";
        String output = controller.processRequest(input);
        String expectOutput = "Error: the booking is invalid!";
        assertEquals(output, expectOutput);
    }

    @Test
    public void inputInvaildDateTimeShouldbeInvaild() {
        String input = "U001 2016-06-02 22:00~22:00 A";
        String output = controller.processRequest(input);
        String expectOutput = "Error: the booking is invalid!";
        assertEquals(output, expectOutput);
    }

    @Test
    public void inputVaildDateTimeShouldbeSucess() {
        String input = "U002 2017-08-01 19:00~22:00 A";
        String output = controller.processRequest(input);
        String expectOutput = "Success: the booking is accepted!";
        assertEquals(output, expectOutput);
    }

    @Test
    public void inputBookedShouldbeError() {
        String input = "U003 2017-08-01 18:00~20:00 A";
        String output = controller.processRequest(input);
        input = "U003 2017-08-01 18:00~20:00 A";
        output = controller.processRequest(input);
        String expectOutput = "Error: the booking conflicts with existing bookings!";
        assertEquals(output, expectOutput);
    }

    @Test
    public void inputCancelFlagShouldbeSucess() {
        String input = "U002 2017-08-01 19:00~22:00 A";
        String output = controller.processRequest(input);
        input = "U002 2017-08-01 19:00~22:00 A C";
        output = controller.processRequest(input);
        String expectOutput = "Success: the booking is accepted!";
        assertEquals(output, expectOutput);
    }

    @Test
    public void inputCanceledShouldbeError() {
        String input = "U002 2017-08-01 19:00~22:00 A C";
        String output = controller.processRequest(input);
        String expectOutput = "Error: the booking being cancelled does not exist!";
        assertEquals(output, expectOutput);
    }
}