package com.briup.jz.service.impl;


import com.briup.jz.bean.Address;
import com.briup.jz.bean.AddressExample;
import com.briup.jz.dao.AddressMapper;
import com.briup.jz.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gujunqi
 * @create 2019-06-10 11:48
 */
@Service
public class IAddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> query(Address address) {
        AddressExample example = new AddressExample();

        if(address.getProvince()!=null){
            example
                    .createCriteria()
                    .andProvinceLike("%"+address.getProvince()+"%");
        }
        if(address.getTelephone()!=null){
            example
                    .createCriteria()
                    .andTelephoneLike("%"+address.getTelephone()+"%");
        }
        if(address.getAddress()!=null){
            example.createCriteria().andAddressLike("%"+address.getAddress()+"%");
        }
        if(address.getUsername()!=null){
            example.createCriteria().andUsernameLike("%"+address.getUsername()+"%");
        }

        return addressMapper.selectByExample(example);
    }

    @Override
    public List<Address> findAll() {
        AddressExample example = new AddressExample();
        return addressMapper.selectByExample(example);
    }

    @Override
    public Address findById(long id) {

        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Address address) throws Exception {
        if (address.getId() == null) {

            addressMapper.insert(address);
        } else {
            addressMapper.updateByPrimaryKey(address);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Address address = addressMapper.selectByPrimaryKey(id);
        if (address == null) {
            throw new Exception("要删除的地址不存在");
        } else {
            addressMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public void batchDelete(Long[] ids) throws Exception {
              for(long id :ids){
            addressMapper.deleteByPrimaryKey(id);
        }
    }
}
