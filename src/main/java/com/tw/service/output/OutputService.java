package com.tw.service.output;

import com.tw.model.Courts;

/**
 * Created by sugarFile on 17/9/11.
 */
public interface OutputService {
    /**
     * 对输出进行处理
     * @param courts
     * return 正确的输出格式
     */
    public String buildOutputStr(Courts courts);
}
