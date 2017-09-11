package com.tw.controller;

import com.tw.controller.controllerlmpl.Controllerlmpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourtControllerTest {
    Controller controller;
    @Before
    public void init(){
        controller = new Controllerlmpl();
    }

    @Test
    public void inputInvaildStringShouldbeInvaild() {
        String input = "abcdefghijklmnopqrst1234567890";
        String output = controller.processRequest(input);
        String expectOutput = "Error: the booking is invalid!";
        assertEquals(output, expectOutput);
    }

}