package com.briup.jz.dao.extend;

import com.briup.jz.bean.extend.ProductExtend;
import com.briup.jz.bean.extend.UserExtend;

import java.awt.image.Kernel;
import java.util.List;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/11
 */
public interface UserExtendMapper {
    List<UserExtend> selectAllWithRole();
    List<UserExtend> selectAllEmployee();
    List<UserExtend> selectAllCustomer();
}
