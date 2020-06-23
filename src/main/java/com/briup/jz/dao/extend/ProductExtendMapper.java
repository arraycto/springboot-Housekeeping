package com.briup.jz.dao.extend;

import com.briup.jz.bean.extend.ProductExtend;

import java.util.List;

/**
 * @Description ：产品接口
 * @Author tj
 * @Date 2020/6/11
 */
public interface ProductExtendMapper {
    List<ProductExtend> selectAllWithCategory();
}
