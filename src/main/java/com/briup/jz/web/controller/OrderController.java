package com.briup.jz.web.controller;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.OrderLine;
import com.briup.jz.bean.extend.OrderExtend;
import com.briup.jz.service.IOrderService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import com.briup.jz.vm.OrderVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description ：订单管理
 * @Author tj
 * @Date 2020/6/13
 */
@RestController
@RequestMapping("/order")
@Api(description = "订单管理接口")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    /**
     * 提交订单
     */
    @PostMapping("commit")
    @ApiOperation("提交订单")
    public Message commit(@RequestBody OrderVM orderVM){

        orderService.commit(orderVM);
        return MessageUtil.success(" 提交成功");
    }

    /**
     * 查询订单
     */
    @GetMapping("findAll")
    @ApiOperation("查询所有订单")
    public Message findAll(){

        return MessageUtil.success("查询成功",orderService.findAll());
    }
    /**
     * 查询订单
     */
    @GetMapping("query")
    @ApiOperation("模糊订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "订单状态",required = false,paramType = "query")
    })
    public Message query(String status){

        return MessageUtil.success("success",orderService.query(status));
    }
    @ApiOperation("通过用户ID查询订单")
    @GetMapping("findOrderByUserId")
    public Message findOrderByUserId(Long UserId) throws Exception{

        return MessageUtil.success("success",orderService.findOrderByUserId(UserId));
    }

    /**
     * 通过ID查询订单
     */
    @GetMapping("findById")
    @ApiOperation("通过id查询订单")
    public Message findById(Long id){
        return MessageUtil.success("查询成功",orderService.findOrderDetailsById(id));
    }
    /**
     * 删除
     */
    @GetMapping("deleteById")
    @ApiOperation(" 通过id删除订单")
    public Message deleteById(Long id){
        orderService.deleteById(id);
        return MessageUtil.success("删除成功");
    }



    /**
     * 通过订单查询用户该订单的所有评价信息
     */
    @ApiOperation("通过订单查询用户该订单的所有评价信息")
    @GetMapping("findAllComment")
    public Message findAllComment(Long id) {
        List<OrderExtend> list = orderService.findAllComment(id);
        return MessageUtil.success("success", list);
    }

    /**
     * 通过订单查询该用户的所有地址信息
     */
    @ApiOperation("通过订单查询该用户的所有地址信息")
    @GetMapping("findAllAddress")
    public Message findAllAddress(Long id) {
        List<OrderExtend> list = orderService.findAllAddress(id);
        return MessageUtil.success("success", list);
    }
    /**
     * 通过订单查询该订单的用户信息
     */
    @ApiOperation("通过订单查询该订单的用户信息")
    @GetMapping("findAllCustomer")
    public Message findAllCustomer(Long id) {
        List<OrderExtend> list = orderService.findAllCustomer(id);
        return MessageUtil.success("success", list);
    }
    /**
     * 通过订单查询员工信息
     */
    @ApiOperation("待付款")
    @GetMapping("payOrder")
    public Message payOrder(Long OrderId) throws Exception{
        orderService.payOrder(OrderId);
        return MessageUtil.success("success");
    }
    @ApiOperation("待派单")
    @GetMapping("sendOrder")
    public Message sendOrder(Long OrderId,Long employeeId) throws Exception{
        orderService.sendOrder(OrderId,employeeId);
        return MessageUtil.success("success");
    }
    @ApiOperation("待服务")
    @GetMapping("rejectOrder")
    public Message rejectOrder(Long OrderId) throws Exception{
        orderService.rejectOrder(OrderId);
        return MessageUtil.success("success");
    }
    @ApiOperation("待确认")
    @GetMapping("confirmOrder")
    public Message confirmOrder(Long OrderId) throws Exception{
        orderService.confirmOrder(OrderId);
        return MessageUtil.success("success");
    }





}
