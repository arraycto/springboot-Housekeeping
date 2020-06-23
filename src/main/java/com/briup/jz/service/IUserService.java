package com.briup.jz.service;

import com.briup.jz.bean.Role;
import com.briup.jz.bean.User;
import com.briup.jz.bean.extend.UserExtend;

import java.util.List;

/**
 * @Description ：用户接口
 * @Author tj
 * @Date 2020/6/11
 */
public interface IUserService {
    List<UserExtend> findAllEmployee();

    List<UserExtend> findAllCustomer();

    List<User> findAll();

    void saveOrUpdate(User user);

    void deleteById(Long id);

    List<UserExtend> findAllWithRole();

    User findById(Long id);


}
