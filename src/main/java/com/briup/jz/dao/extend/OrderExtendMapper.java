package com.briup.jz.dao.extend;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.extend.OrderExtend;

import java.util.List;

/**
 * @Description ：订单接口
 * @Author tj
 * @Date 2020/6/13
 */
public interface OrderExtendMapper {
    //多条件符合查询
    List<OrderExtend> query(Long id, String status);
    List<OrderExtend> findOrderByUserId(Long UserId);

    List<OrderExtend> findAllComment(Long id);

    List<OrderExtend> findAllAddress(Long id);

    List<OrderExtend> findAllCustomer(Long id);
}
