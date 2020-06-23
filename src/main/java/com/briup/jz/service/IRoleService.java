package com.briup.jz.service;

import com.briup.jz.bean.Role;
import com.briup.jz.utils.CustomerException;

import java.util.List;

/**
 * @Description ：角色接口
 * @Author tj
 * @Date 2020/6/15
 */
public interface IRoleService {
    List<Role> findAll();

    Role findById(long id);

    void saveOrEdit(Role role) throws CustomerException;

    void delById(long id) throws CustomerException;
}
