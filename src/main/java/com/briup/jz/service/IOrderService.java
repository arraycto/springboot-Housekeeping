package com.briup.jz.service;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.extend.OrderExtend;
import com.briup.jz.utils.CustomerException;
import com.briup.jz.vm.OrderVM;

import java.util.List;

/**
 * @Description ：订单接口
 * @Author tj
 * @Date 2020/6/13
 */
public interface IOrderService {
    /**
     * 新建订单
     * @return
     */
    void commit(OrderVM orderVM) throws CustomerException;

    /**
     * 查询全部订单
     * @return
     */
    List<Order> findAll();
    /**
     * 根据状态查询订单
     * @return
     */
    List<OrderExtend> query(String status);

    List<OrderExtend> findOrderByUserId(Long UserId);


    /**
     * 跟分局订单id查询订单详情（顾客/地址/订单内容）
     * @return
     */
    OrderExtend findOrderDetailsById(Long id);

    /**
     * 支付订单接口
     * @param orderId
     */
    void payOrder(Long orderId)throws Exception;

    /**
     * 派单接口（进入服务）
     * @param orderId
     */
    void sendOrder(Long orderId,Long employeeId)throws Exception;

    /**
     * 接单接口（进入待服务）
     * @param orderId
     */
    //void takeOrder(Long orderId);

    /**
     * 服务（服务结束进入待确认状态）
     * @param orderId
     */
    void rejectOrder(Long orderId)throws Exception;

    /**
     * 确认订单（订单进入已完成状态）
     * @param orderId
     */
    void confirmOrder(Long orderId)throws Exception;

    void deleteById(Long id) throws CustomerException;

    List<OrderExtend> findAllComment(Long id);

    List<OrderExtend> findAllAddress(Long id);

    List<OrderExtend> findAllCustomer(Long id);
}
