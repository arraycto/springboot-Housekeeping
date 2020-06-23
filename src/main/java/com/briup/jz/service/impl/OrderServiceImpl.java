package com.briup.jz.service.impl;

import com.briup.jz.bean.*;
import com.briup.jz.bean.extend.OrderExtend;
import com.briup.jz.dao.OrderLineMapper;
import com.briup.jz.dao.OrderMapper;
import com.briup.jz.dao.UserMapper;
import com.briup.jz.dao.extend.OrderExtendMapper;
import com.briup.jz.service.IOrderService;
import com.briup.jz.utils.CustomerException;
import com.briup.jz.vm.OrderVM;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.omg.CORBA.ORB;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description ：order实现类
 * @Author tj
 * @Date 2020/6/13
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private OrderLineMapper orderLineMapper;
    @Resource
    private OrderExtendMapper orderExtendMapper;

    @Override
    public void commit(OrderVM orderVM) throws CustomerException {
        /**
         * 1、分别获得订单信息、订单项信息
         * 2、先保存订单信息 在保存订单项信息
         */
        Order order = new Order();
        order.setTotal(orderVM.getTotal());
        order.setAddressId(orderVM.getAddressId());
        order.setCustomerId(orderVM.getCustomerId());
        order.setEmployeeId(orderVM.getEmployeeId());
        order.setOrderTime(new Date().getTime());
        order.setStatus(OrderExtend.STATUS_DFK);
        List<OrderLine> orderLines = orderVM.getOrderLines();
        orderMapper.insert(order);
        for (OrderLine orderLine : orderLines) {
            //设置order与orderLine之间的关键外键维护
            orderLine.setOrderId(order.getId());
            orderLineMapper.insert(orderLine);
        }
    }

    @Override
    public List<Order> findAll() {
        return orderMapper.selectByExample(new OrderExample());
    }

    @Override
    public List<OrderExtend> query(String status) {

        return orderExtendMapper.query(null,status);
    }

    @Override
    public List<OrderExtend> findOrderByUserId(Long UserId) {
        return orderExtendMapper.findOrderByUserId(UserId);
    }

    @Override
    public OrderExtend findOrderDetailsById(Long id) {
        List<OrderExtend> list = orderExtendMapper.query(id,null);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void payOrder(Long orderId)throws Exception{
        //订单支付（进入待派单状态）
        //简化支付流程
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null){
            //订单不存在 抛出异常
            throw new Exception("该订单不存在");
        }
        //订单支付（进入待派单状态）
        order.setStatus(OrderExtend.STATUS_DPD);
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void sendOrder(Long orderId, Long employeeId)throws Exception{
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null){
            //订单不存在 抛出异常
            throw new Exception("该订单不存在");
        }else if(!order.getStatus().equals("待派单")){
            throw new Exception("该订单异常");
        }
        //订单支付（进入待派单状态）
        User emp = userMapper.selectByPrimaryKey(employeeId);
        if (emp == null){
            throw new Exception("该员工不存在");
        }
        //进入带服务状态（省略待接单）
        order.setStatus(OrderExtend.STATUS_DFW);
        order.setEmployeeId(employeeId);
        orderMapper.updateByPrimaryKey(order);
    }

//    @Override
//    public void takeOrder(Long orderId) {
//
//    }

    @Override
    public void rejectOrder(Long orderId)throws Exception{
        //服务开始
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null){
            //订单不存在 抛出异常
            throw new Exception("该订单不存在");
        }else if(!order.getStatus().equals("待服务")){
            throw new Exception("该订单异常");
        }
        order.setStatus(OrderExtend.STATUS_DQR);
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void confirmOrder(Long orderId)throws Exception{
        //确认订单
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null){
            //订单不存在 抛出异常
            throw new Exception("该订单不存在");
        }else if(!order.getStatus().equals("待确认")){
            throw new Exception("该订单异常");
        }
        order.setStatus(OrderExtend.STATUS_YWC);
        orderMapper.updateByPrimaryKey(order);
    }


    @Override
    public void deleteById(Long id) throws CustomerException{
        //判断id是否存在
        Order order =orderMapper.selectByPrimaryKey(id);
        if (order == null){
            //不存在抛出报错！
            throw new CustomerException("删除失败，要删除的数据不存在");

        }
        //存在可以删除，
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<OrderExtend> findAllComment(Long id) {
        return orderExtendMapper.findAllComment(id);
    }

    @Override
    public List<OrderExtend> findAllAddress(Long id) {
        return orderExtendMapper.findAllAddress(id);
    }

    @Override
    public List<OrderExtend> findAllCustomer(Long id) {
        return orderExtendMapper.findAllCustomer(id);
    }
}
