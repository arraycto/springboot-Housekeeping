package com.briup.jz.web.controller;

import com.briup.jz.bean.Product;
import com.briup.jz.bean.User;
import com.briup.jz.bean.UserExample;
import com.briup.jz.bean.extend.AccountCustomerExtend;
import com.briup.jz.bean.extend.UserExtend;
import com.briup.jz.service.IProductService;
import com.briup.jz.service.IUserService;
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
@RequestMapping("/user")
@Api(description = "用户管理接口")
public class UserController {
    @Autowired
    private IUserService userService;
    @ApiOperation(value = "级联角色查询")
    @GetMapping("findAllWithRole")
    private Message findAllWithRole(){
        return MessageUtil.success(userService.findAllWithRole());
    }
    @ApiOperation(value = "查询所有用户")
    @GetMapping("findAll")
    private Message  findAll(){
        return MessageUtil.success(userService.findAll());
    }
    @ApiOperation(value = "查询所有用户")
    @GetMapping("findAllEmployee")
    private Message findAllEmployee(){
        return MessageUtil.success(userService.findAllEmployee());
    }

    @ApiOperation(value = "查询所有用户")
    @GetMapping("findAllCustomer")
    private Message findAllCustomer(){
        return MessageUtil.success(userService.findAllCustomer());
    }

    @ApiOperation(value = "通过i查询用户")
    @GetMapping("findById")
    public Message findById(Long id) {

        return MessageUtil.success(userService.findById(id));
    }

    @ApiOperation(value = "通过id删除用户")
    @GetMapping("deleteById")
    public Message deleteById(Long id) {
        userService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation(value = "保存或更新用户")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(User user){
        Long id = 2l;
        user.setRoleId(id);
        userService.saveOrUpdate(user);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation(value = "保存或更新员工")
    @PostMapping("saveOrUpdateEmp")
    public Message saveOrUpdateEmp(User user){
        Long id = 3l;
        user.setRoleId(id);

        userService.saveOrUpdate(user);

        return MessageUtil.success("保存成功");
    }

    @GetMapping("auditing")
    public Message auditing(Long id){
        User user = userService.findById(id);
        user.setStatus("启用");
        userService.saveOrUpdate(user);
        return MessageUtil.success("通过审核");
    }
    @GetMapping("refuseAuditing")
    public Message refuseAuditing(Long id){
        User user = userService.findById(id);
        user.setStatus("禁用");
        userService.saveOrUpdate(user);
        return MessageUtil.success("拒绝审核");
    }

//    @GetMapping("findAddressByUserId")
//    public Message findOrderByUserId(Long id){
//        List<AccountCustomerExtend> list = userService.findMyOrder(id);
//        return MessageUtil.success("success", list);
//    }

}
