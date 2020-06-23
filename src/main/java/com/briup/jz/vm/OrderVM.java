package com.briup.jz.vm;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.OrderLine;

import java.util.List;

/**
 * @Description ：订单视图类
 * @Author tj
 * @Date 2020/6/13
 */
public class OrderVM extends Order {
    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
