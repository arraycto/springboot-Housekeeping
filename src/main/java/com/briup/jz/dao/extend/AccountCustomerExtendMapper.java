package com.briup.jz.dao.extend;

import com.briup.jz.bean.extend.AccountCustomerExtend;

import java.util.List;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/14
 */
public interface AccountCustomerExtendMapper {
    List<AccountCustomerExtend> findMyAddress(Long id) ;
    List<AccountCustomerExtend> findMyMessage(Long id);
    List<AccountCustomerExtend> findMyOrder(Long id);
}
