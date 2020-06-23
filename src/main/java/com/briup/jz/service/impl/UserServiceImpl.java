package com.briup.jz.service.impl;

import com.briup.jz.bean.Role;
import com.briup.jz.bean.User;
import com.briup.jz.bean.UserExample;
import com.briup.jz.bean.extend.UserExtend;
import com.briup.jz.dao.UserMapper;
import com.briup.jz.dao.extend.UserExtendMapper;
import com.briup.jz.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/11
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserExtendMapper userExtendMapper;

    @Override
    public List<UserExtend> findAllEmployee() {
        return userExtendMapper.selectAllEmployee();
    }

    @Override
    public List<UserExtend> findAllCustomer() {
        return userExtendMapper.selectAllCustomer();
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public void saveOrUpdate(User user) {
        if (user.getId()!=null){
            userMapper.updateByPrimaryKey(user);
        }else {
            userMapper.insert(user);
        }
    }

    @Override
    public void deleteById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserExtend> findAllWithRole() {
        return userExtendMapper.selectAllWithRole();
    }

    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }


}
