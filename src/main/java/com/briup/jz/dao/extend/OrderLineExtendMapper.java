package com.briup.jz.dao.extend;

import com.briup.jz.bean.OrderLine;
import com.briup.jz.bean.extend.OrderExtend;

import java.util.List;

/**
 * @Description ：订单拓展接口
 * @Author tj
 * @Date 2020/6/13
 */
public interface OrderLineExtendMapper {
    List<OrderLine> selectByOrderId(Long id);
}
