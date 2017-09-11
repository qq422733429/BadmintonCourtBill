package com.tw.service.output;

import com.tw.model.Courts;
import com.tw.model.Record;
import com.tw.model.TimeBucket;
import com.tw.service.output.outputServicelmpl.OutputServicelmpl;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by sugarFile on 17/9/11.
 */
public class OutputServicelmplTest {
    @Test
    public void testOutput(){
        Courts courts =new Courts(4);
        Record record = new Record();
        record.setUserId("U001");
        TimeBucket timeBucket = new TimeBucket();
        Date start = new Date(117, 8, 10, 18, 0);
        Date end = new Date(117, 8, 10, 20, 0);
        timeBucket.setStartTime(start);
        timeBucket.setEndTime(end);
        record.setBookingTime(timeBucket);
        record.setPrice(120);
        record.setCancel(false);
        courts.findCourtById("A").getBookingRecordList().add(record);
        courts.findCourtById("A").setPrice(120);
        OutputService outputService =new OutputServicelmpl();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("收入汇总\n---\n场地:A\n2017-09-10 18:00~20:00 120元\n小计：120元\n\n");
        stringBuffer.append("场地:B\n小计：0元\n\n");
        stringBuffer.append("场地:C\n小计：0元\n\n");
        stringBuffer.append("场地:D\n小计：0元\n---\n总计：120元");
        String result = outputService.buildOutputStr(courts);
        assertEquals(result,stringBuffer.toString());


    }

}