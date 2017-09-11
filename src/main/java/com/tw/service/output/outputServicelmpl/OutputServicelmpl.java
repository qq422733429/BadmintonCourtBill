package com.tw.service.output.outputServicelmpl;

import com.tw.model.Courts;
import com.tw.service.output.OutputService;

/**
 * Created by sugarFile on 17/9/11.
 */
public class OutputServicelmpl implements OutputService {
    @Override
    public String buildOutputStr(Courts courts) {
        return courts.toString();
    }
}
