package com.briup.jz.web.controller;

import com.briup.jz.bean.Product;
import com.briup.jz.bean.extend.ProductExtend;
import com.briup.jz.service.IProductService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
@RequestMapping("/product")
@Api(description = "产品管理接口")
public class ProductController {
    @Autowired
    private IProductService productService;


    /**
     * 查询所有商品并级联查询
     * @return
     */
    @ApiOperation("级联查询所有商品")
    @GetMapping("findAllWithCategory")
    public Message findAllWithCategory() {
        List<ProductExtend> list = productService.findAllWithCategory();
        return MessageUtil.success(list);
    }

    /**
     * 查询所有产品
     * @return
     */
    @ApiOperation("查询所有产品")
    @GetMapping("findAll")
    public Message findAll() {
        List<Product> list =  productService.findAll();
        return MessageUtil.success(list);
    }

    /**
     * 删除产品
     * @param id
     * @return
     */
    @ApiOperation("通过id删除产品信息")
    @GetMapping("deleteById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "唯一编号",required = true,paramType = "query")
    })
    public Message deleteById(Long id) {

        productService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    /**
     * 新增或修改产品
     * @param product
     * @return
     */
    @ApiOperation("新增或修改产品")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Product product){
        productService.saveOrUpdate(product);
        return MessageUtil.success("保存成功");
    }
}