package com.briup.jz.bean.extend;

import com.briup.jz.bean.*;

import java.util.List;

/**
 * @Description ：订单拓展类
 * @Author tj
 * @Date 2020/6/13
 */
public class OrderExtend extends Order {
    public static final String STATUS_DFK="待付款";
    public static final String STATUS_DPD="待派单";
    public static final String STATUS_DFW="待服务";
    public static final String STATUS_DQR="待确认";
    public static final String STATUS_YWC="已完成";

    private User customer;
    private User employee;
    private Address address;
    private List<OrderLine> orderLines;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    private Comment comment;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
