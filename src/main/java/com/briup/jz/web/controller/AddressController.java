package com.briup.jz.web.controller;


import com.briup.jz.bean.Address;
import com.briup.jz.service.IAddressService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author gujunqi
 * @create 2019-06-10 13:41
 */
@RestController
@RequestMapping("/address")
@Api(description = "地址管理接口")
public class AddressController {
    //模糊查询
    @Autowired
    private IAddressService addressService;

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Address address) {
        List<Address> list=addressService.query(address);
        return MessageUtil.success("success",list);
    }
    //查询所有地址
    @ApiOperation("查询所有地址")
    @GetMapping("findAll")
    public Message findAll(){
        List<Address> list=addressService.findAll();
        return MessageUtil.success("success",list);
    }
    //通过id查询地址
    @ApiOperation("通过id查询地址")
    @GetMapping("findById")
    public Message findById(@ApiParam(value = "主键", required = true) @RequestParam(value = "id") long id) {
        Address address=addressService.findById(id);
        return MessageUtil.success("success",address);
    }
    @ApiOperation("保存或更新地址信息")
    @PostMapping ("saveOrUpdate")
    public Message saveOrUpdate( Address address) throws Exception {
            addressService.saveOrUpdate(address);
            return MessageUtil.success("更新成功");
    }
    @ApiOperation("通过id删除地址信息")
    @GetMapping("deleteById")
    public Message deleteById(@NotNull @RequestParam("id") Long id) throws Exception {
            addressService.deleteById(id);
            return MessageUtil.success("删除成功");
    }
//增加了批量删除地址信息
    @ApiOperation("批量删除地址信息")
    @PostMapping("batchDelete")
    public Message batchDelete(@NotNull(message = "ids不能为空") Long[] ids) throws Exception{
        addressService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}

