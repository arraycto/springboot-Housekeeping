package com.briup.jz.service;

import com.briup.jz.bean.Address;

import java.util.List;

/**
 * @author gujunqi
 * @create 2019-06-10 13:36
 */
public interface IAddressService {
    List<Address> query(Address address);
    List<Address>  findAll();
    Address findById(long id);
    void saveOrUpdate(Address address) throws Exception;
    void deleteById(long id) throws Exception;
    void batchDelete(Long[] ids) throws Exception;
}
