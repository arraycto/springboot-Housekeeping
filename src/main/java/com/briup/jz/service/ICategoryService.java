package com.briup.jz.service;

import com.briup.jz.bean.Category;
import com.briup.jz.bean.extend.CategoryExtend;

import java.util.List;

/**
 * @Description ：栏目业务接口
 * @Author tj
 * @Date 2020/6/11
 */
public interface ICategoryService {
    List<Category> findAll();

    void saveOrUpdate(Category category);

    void deleteById(Long id);

    List<CategoryExtend> findAllWithChild();
}
