package com.tw.controller.controllerlmpl;

import com.tw.controller.Controller;
import com.tw.model.Courts;
import com.tw.model.Order;
import com.tw.service.input.InputService;
import com.tw.service.input.inputServicelmpl.InputServicelmpl;
import com.tw.service.output.OutputService;
import com.tw.service.output.outputServicelmpl.OutputServicelmpl;
import com.tw.service.process.ProcessService;
import com.tw.service.process.ProcessServicelmpl.ProcessServicelmpl;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by sugarFile on 17/9/11.
 */
public class Controllerlmpl implements Controller{
    private InputService inputService;
    private ProcessService processService;
    private OutputService outputService;
    private Courts courts;

    public Controllerlmpl() {
        this.inputService = new InputServicelmpl();
        this.processService = new ProcessServicelmpl();
        this.outputService = new OutputServicelmpl();
        this.courts = new Courts(4);
    }
    @Override
    public String processRequest(String input){
        if(input.equals(" ")){
            return outputService.buildOutputStr(courts);
        }else {
            Order order = inputService.buildOrders(input);
            if (order == null) {
                return "Error: the booking is invalid!";
            } else {
                int result = processService.calculateAllKindsOfBill(courts, inputService.buildOrders(input));
                if(result==0){
                    return "Success: the booking is accepted!";
                }
                if(result==1){
                    return "Error: the booking conflicts with existing bookings!";
                }
                if(result==2) {
                    return "Error: the booking being cancelled does not exist!";
                }
                throw new RuntimeException("unexpected process result");

            }
        }
    }
}

