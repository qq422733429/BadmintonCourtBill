package com.tw.service.process;

import com.tw.model.Courts;
import com.tw.model.Order;
import com.tw.model.TimeBucket;
import com.tw.service.input.InputService;
import com.tw.service.input.inputServicelmpl.InputServicelmpl;
import com.tw.service.process.ProcessServicelmpl.ProcessServicelmpl;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by sugarFile on 17/9/11.
 */
public class ProcessServicelmplTest {
    @Test
    public void inputExistBookingShouldBeRejected() {
        InputService inputService = new InputServicelmpl();
        ProcessService processService = new ProcessServicelmpl();
        Courts courts = new Courts(4);
        TimeBucket first = new TimeBucket();
        Date start = new Date(117,9,11,18,0);
        Date end = new Date(117,9,11,22,0);
        first.setStartTime(start);
        first.setEndTime(end);
        Order order = new Order("U001",first,"A",false);
        int result=processService.calculateAllKindsOfBill(courts, order);
        if(result==0){
            first = new TimeBucket();
            start = new Date(117,9,11,18,0);
            end = new Date(117,9,11,22,0);
            first.setStartTime(start);
            first.setEndTime(end);
            order = new Order("U001",first,"A",false);
            result=processService.calculateAllKindsOfBill(courts, order);
        }
        assertEquals(result, 1);
    }

    @Test
    public void inputNotExistCancelShouldBeRejected() {
        InputService inputService = new InputServicelmpl();
        ProcessService processService = new ProcessServicelmpl();
        Courts courts = new Courts(4);
        TimeBucket first = new TimeBucket();
        Date start = new Date(117,9,11,18,0);
        Date end = new Date(117,9,11,22,0);
        first.setStartTime(start);
        first.setEndTime(end);
        Order order = new Order("U001",first,"A",true);
        int result=processService.calculateAllKindsOfBill(courts, order);
        assertEquals(result, 2);
    }

    @Test
    public void calculateWeekdayBookingBillShouldBeCorrect() {
        InputService inputService = new InputServicelmpl();
        ProcessService processService = new ProcessServicelmpl();
        Courts courts = new Courts(4);
        TimeBucket first = new TimeBucket();
        Date start = new Date(117,9,11,18,0);
        Date end = new Date(117,9,11,20,0);
        first.setStartTime(start);
        first.setEndTime(end);
        Order order = new Order("U001",first,"A",false);
        int result=processService.calculateAllKindsOfBill(courts, order);
        assertEquals(result,0);
        String ee = String.valueOf(courts.findCourtById("A").getPrice());
        assertEquals(ee, "160.0");
    }

    @Test
    public void calculateWeekendBookingBillShouldBeCorrect() {
        InputService inputService = new InputServicelmpl();
        ProcessService processService = new ProcessServicelmpl();
        Courts courts = new Courts(4);
        TimeBucket first = new TimeBucket();
        Date start = new Date(117, 8, 10, 18, 0);
        Date end = new Date(117, 8, 10, 20, 0);
        first.setStartTime(start);
        first.setEndTime(end);
        Order order = new Order("U001", first, "A", false);
        int result = processService.calculateAllKindsOfBill(courts, order);
        assertEquals(result, 0);
        String ee = String.valueOf(courts.findCourtById("A").getPrice());
        assertEquals(ee, "120.0");
    }

}