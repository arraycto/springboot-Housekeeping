package com.briup.jz.service.impl;

import com.briup.jz.bean.AccountCustomer;
import com.briup.jz.bean.AccountCustomerExample;
import com.briup.jz.bean.extend.AccountCustomerExtend;
import com.briup.jz.dao.AccountCustomerMapper;
import com.briup.jz.dao.extend.AccountCustomerExtendMapper;
import com.briup.jz.service.IAccountCustomerService;
import com.briup.jz.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description ：顾客实现类
 * @Author tj
 * @Date 2020/6/14
 */
@Service
public class AccountCustomServiceImpl implements IAccountCustomerService {
    @Resource
    private AccountCustomerMapper accountCustomerMapper;
    @Resource
    private AccountCustomerExtendMapper accountCustomerExtendMapper;


    @Override
    public List<AccountCustomer> findAll() {
        return accountCustomerMapper.selectByExample(new AccountCustomerExample());
    }

    @Override
    public AccountCustomer findById(long id) {
        return accountCustomerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrupdate(AccountCustomer accountCustomer) throws CustomerException {


        if (accountCustomer.getId() == null) {
            accountCustomerMapper.insert(accountCustomer);
        } else {
            accountCustomerMapper.updateByPrimaryKey(accountCustomer);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        AccountCustomer accountCustomer = accountCustomerMapper.selectByPrimaryKey(id);
        if (accountCustomer == null) {
            throw new Exception("要删除的地址不存在");
        } else {
            accountCustomerMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void batchDelete(Long[] ids) throws Exception {
        for(long id :ids){
            accountCustomerMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<AccountCustomerExtend> findMyMessage(Long id) {
        return accountCustomerExtendMapper.findMyMessage(id);
    }

    @Override
    public List<AccountCustomerExtend> findMyAddress(Long id) {
        return accountCustomerExtendMapper.findMyAddress(id);
    }

    @Override
    public List<AccountCustomerExtend> findMyOrder(Long id) {
        return accountCustomerExtendMapper.findMyOrder(id);
    }
}
