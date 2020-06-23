package com.briup.jz.service.impl;

import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.bean.AccountEmployeeExample;
import com.briup.jz.dao.AccountEmployeeMapper;
import com.briup.jz.service.IAccountEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/15
 */
@Service
public class AccountEmployeeServiceImpl implements IAccountEmployeeService {
    @Resource
    private AccountEmployeeMapper accountEmployeeMapper;


    //查询所有的员工
    @Override
    public List<AccountEmployee> findAll() {
        return accountEmployeeMapper.selectByExample(new AccountEmployeeExample());
    }

    @Override
    public AccountEmployee findById(long id) {
        // 调用mapper层代码完成查询操作
        return accountEmployeeMapper.selectByPrimaryKey(id);
    }

    //保存或更新信息
    @Override
    public void saveOrUpdate(AccountEmployee accountEmployee) throws Exception {
        if (accountEmployee.getId() == null) {
            // 初始化属性
            accountEmployeeMapper.insert(accountEmployee);
        } else {
            accountEmployeeMapper.updateByPrimaryKey(accountEmployee);
        }
    }
    //通过ID删除员工
    @Override
    public void deleteById(long id) throws Exception {
        AccountEmployee accountEmployee = accountEmployeeMapper.selectByPrimaryKey(id);
        if (accountEmployee == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            accountEmployeeMapper.deleteByPrimaryKey(id);
        }
    }
    //批量删除员工
    @Override
    public void batchDelete(Long[] ids) throws Exception {
        for(long id :ids){
            accountEmployeeMapper.deleteByPrimaryKey(id);
        }
    }
}
