package com.briup.jz.service;

import com.briup.jz.bean.AccountCustomer;
import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.bean.AccountSystem;
import com.briup.jz.utils.CustomerException;

import javax.swing.undo.CannotUndoException;
import java.util.List;

/**
 * @Description ：管理员个人信息
 * @Author tj
 * @Date 2020/6/14
 */
public interface IAccountSystemService {
    List<AccountSystem> findAll();

    AccountSystem findById(long id);

    void saveOrUpdate(AccountSystem accountSystem) throws Exception;

    void  deleteById(long id) throws Exception;

}
