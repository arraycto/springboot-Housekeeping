package com.briup.jz.service.impl;

import com.briup.jz.bean.Category;
import com.briup.jz.bean.CategoryExample;
import com.briup.jz.bean.extend.CategoryExtend;
import com.briup.jz.dao.CategoryMapper;
import com.briup.jz.dao.extend.CategoryExtendMapper;
import com.briup.jz.service.ICategoryService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description :栏目接口实现类
 * @Author tj
 * @Date 2020/6/11
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryExtendMapper categoryExtendMapper;
    @Override
    public List<Category> findAll() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public void saveOrUpdate(Category category) {
        if (category.getId() !=null){
            categoryMapper.updateByPrimaryKey(category);
        }else {
            categoryMapper.insert(category);
        }
    }

    @Override
    public void deleteById(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryExtend> findAllWithChild() {
        return categoryExtendMapper.selectAllWithChild();
    }


}
