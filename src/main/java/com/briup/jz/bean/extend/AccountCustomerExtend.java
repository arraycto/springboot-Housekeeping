package com.briup.jz.bean.extend;

import com.briup.jz.bean.AccountCustomer;
import com.briup.jz.bean.Address;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/14
 */
public class AccountCustomerExtend extends AccountCustomer {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
