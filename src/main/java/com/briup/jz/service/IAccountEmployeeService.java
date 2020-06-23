package com.briup.jz.service;

import com.briup.jz.bean.AccountEmployee;


import java.util.List;

/**
 * @Description ：员工个人信息
 * @Author tj
 * @Date 2020/6/14
 */
public interface IAccountEmployeeService {
    List<AccountEmployee> findAll();

    AccountEmployee findById(long id);

    void saveOrUpdate(AccountEmployee accountEmployee) throws Exception;

    void  deleteById(long id) throws Exception;

    void batchDelete(Long ids[])throws  Exception;
}
