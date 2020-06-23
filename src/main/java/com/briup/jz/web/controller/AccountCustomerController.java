package com.briup.jz.web.controller;

import com.briup.jz.bean.AccountCustomer;
import com.briup.jz.bean.extend.AccountCustomerExtend;
import com.briup.jz.dao.AccountCustomerMapper;
import com.briup.jz.service.IAccountCustomerService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/14
 */
@RestController
@RequestMapping("/customer")
@Api(description = "客户账号管理接口")
public class AccountCustomerController {
    @Autowired
    private IAccountCustomerService accountCustomerService;
    @Resource
    private AccountCustomerMapper accountCustomerMapper;

    @ApiOperation("查询所有客户")
    @GetMapping("findAll")
    public Message findAll() {
        List<AccountCustomer> list = accountCustomerService.findAll();
        return MessageUtil.success("success", list);
    }
    //通过id查询客户
    @ApiOperation("通过id查询客户")
    @GetMapping("findById")
    public Message findById(@ApiParam(value = "主键", required = true) @RequestParam(value = "id") long id) {
        AccountCustomer customer = accountCustomerService.findById(id);
        return MessageUtil.success("success", customer);
    }
    //保存货更新客户信息
    @ApiOperation("保存或更新客户信息")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate( AccountCustomer customer) {
        accountCustomerService.saveOrupdate(customer);
        return MessageUtil.success("更新成功");

    }

    @ApiOperation("通过id删除客户信息")
    @GetMapping("deleteById")
    public Message deleteById(@NotNull @RequestParam("id") long id) throws Exception {
        accountCustomerService.deleteById(id);
        return MessageUtil.success("删除成功");

    }
    //增加了批量删除客户信息
    @ApiOperation("批量删除客户信息")
    @PostMapping("batchDelete")
    public Message batchDelete(@NotNull(message = "id不能为空")@RequestBody Long[] ids) throws Exception {
        for(long id :ids){
            accountCustomerMapper.deleteByPrimaryKey(id);
        }

          //  accountCustomerService.batchDelete(ids);
        return MessageUtil.success("成功");
    }
    //查询用户的地址信息
    @ApiOperation("查询用户的地址信息")
    @GetMapping("findMyAddress")
    public Message findMyAddress(Long id) {
        List<AccountCustomerExtend> list = accountCustomerService.findMyAddress(id);
        return MessageUtil.success("success", list);
    }
    //查询用户的基本信息
    @ApiOperation("查询用户的基本信息")
    @GetMapping("findMyMessage")
    public Message findMyMessage(Long id) {
        List<AccountCustomerExtend> list = accountCustomerService.findMyMessage(id);
        return MessageUtil.success("success", list);
    }
    //查询用户的订单信息
    @ApiOperation("查询用户的订单信息")
    @GetMapping("findMyOrder")
    public Message findMyOrder(Long id) {
        List<AccountCustomerExtend> list = accountCustomerService.findMyOrder(id);
        return MessageUtil.success("success", list);
    }

}
