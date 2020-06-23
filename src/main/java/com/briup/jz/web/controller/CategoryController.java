package com.briup.jz.web.controller;

import com.briup.jz.bean.Category;
import com.briup.jz.bean.Product;
import com.briup.jz.bean.extend.CategoryExtend;
import com.briup.jz.bean.extend.ProductExtend;
import com.briup.jz.service.ICategoryService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/11
 */
@RestController
@RequestMapping("/category")
@Api(description = "评论管理控制器")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("findAllWithChild")
    @ApiOperation("级联查询分类信息")
    public Message findAllWithCategory() {

        return MessageUtil.success(categoryService.findAllWithChild());
    }
    @ApiOperation("查询所有分类信息")
    @GetMapping("findAll")
    public Message findAll() {

        return MessageUtil.success(categoryService.findAll());
    }
    @ApiOperation("根据id删除信息")
    @GetMapping("deleteById")
    public Message deleteById(Long id) {
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation("新增或修改分类信息")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Category category){
        categoryService.saveOrUpdate(category);
        return MessageUtil.success("保存成功");
    }

}
