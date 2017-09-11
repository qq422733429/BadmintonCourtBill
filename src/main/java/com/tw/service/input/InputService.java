package com.tw.service.input;

import com.tw.model.Order;

/**
 * Created by sugarFile on 17/9/11.
 */
public interface InputService {
    /*
     *  对原始输入的字符串进行处理，转化成order订单，以供使用
     *  @param ordersInput
     *  @return Order
     */
    public Order buildOrders(String ordersInput);
}
