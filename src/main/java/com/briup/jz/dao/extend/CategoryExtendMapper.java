package com.briup.jz.dao.extend;

import com.briup.jz.bean.extend.CategoryExtend;

import java.util.List;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/11
 */
public interface CategoryExtendMapper {
    List<CategoryExtend> selectAllWithChild();
}
