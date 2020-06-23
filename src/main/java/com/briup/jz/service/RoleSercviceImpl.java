package com.briup.jz.service;

import com.briup.jz.bean.Role;
import com.briup.jz.bean.RoleExample;
import com.briup.jz.dao.RoleMapper;
import com.briup.jz.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/15
 */
@Service
public class RoleSercviceImpl implements IRoleService {
    @Resource
    private RoleMapper roleMapper;


    @Override
    public List<Role> findAll() {
        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public Role findById(long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrEdit(Role role) throws CustomerException {
        if(role.getId()==null){
            roleMapper.insert(role);
        }else{
            if(roleMapper.selectByPrimaryKey(role.getId())==null){
                throw new CustomerException("修改失败，数据不存在");
            }
            roleMapper.updateByPrimaryKey(role);
        }
    }

    @Override
    public void delById(long id) throws CustomerException {
        if(roleMapper.selectByPrimaryKey(id)==null){
            System.out.println("shuju"+roleMapper.selectByPrimaryKey(id));
            throw new CustomerException("删除失败，数据不存在");
        }
        roleMapper.deleteByPrimaryKey(id);
    }
}
