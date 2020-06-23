package com.briup.jz.service.impl;

import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.bean.AccountEmployeeExample;
import com.briup.jz.bean.AccountSystem;
import com.briup.jz.bean.AccountSystemExample;
import com.briup.jz.dao.AccountEmployeeMapper;
import com.briup.jz.dao.AccountSystemMapper;
import com.briup.jz.service.IAccountEmployeeService;
import com.briup.jz.service.IAccountSystemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/15
 */
@Service
public class AccountSystemServiceImpl implements IAccountSystemService {
    @Resource
    private AccountSystemMapper accountSystemMapper;


    //查询所有的员工
    @Override
    public List<AccountSystem> findAll() {
        return accountSystemMapper.selectByExample(new AccountSystemExample());
    }

    @Override
    public AccountSystem findById(long id) {
        // 调用mapper层代码完成查询操作
        return accountSystemMapper.selectByPrimaryKey(id);
    }

    //保存或更新信息
    @Override
    public void saveOrUpdate(AccountSystem accountSystem) throws Exception {
        if (accountSystem.getId() == null) {
            // 初始化属性
            accountSystemMapper.insert(accountSystem);
        } else {
            accountSystemMapper.updateByPrimaryKey(accountSystem);
        }
    }
    //通过ID删除员工
    @Override
    public void deleteById(long id) throws Exception {
        AccountSystem accountSystem = accountSystemMapper.selectByPrimaryKey(id);
        if (accountSystem == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            accountSystemMapper.deleteByPrimaryKey(id);
        }
    }
    //批量删除员工

    public void batchDelete(Long[] ids) throws Exception {
        for(long id :ids){
            accountSystemMapper.deleteByPrimaryKey(id);
        }
    }
}
