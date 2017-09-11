package com.tw.service.process;

import com.tw.model.Courts;
import com.tw.model.Order;

public interface ProcessService {
    /**
     * 根据处理后的输入，进行费用计算,返回计算是否成功完成
     * @param order
     * @return true
     */
    public int calculateAllKindsOfBill(Courts courts, Order order);
}
