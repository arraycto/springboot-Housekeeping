package com.briup.jz.service;

import com.briup.jz.bean.AccountCustomer;
import com.briup.jz.bean.extend.AccountCustomerExtend;
import com.briup.jz.utils.CustomerException;

import java.util.List;

/**
 * @Description ：顾客信息
 * @Author tj
 * @Date 2020/6/14
 */
public interface IAccountCustomerService {

    List<AccountCustomer>  findAll();
    AccountCustomer findById(long id);
    void saveOrupdate (AccountCustomer accountCustomer) throws CustomerException;
    void deleteById(long id) throws Exception;
    void batchDelete(Long ids[])throws  Exception;
    List<AccountCustomerExtend> findMyMessage(Long id);     //查找用户自己的基本信息
    List<AccountCustomerExtend> findMyAddress(Long id);    //查找用户自己的地址
    List<AccountCustomerExtend> findMyOrder(Long id);      //查找用户个人订单
}
