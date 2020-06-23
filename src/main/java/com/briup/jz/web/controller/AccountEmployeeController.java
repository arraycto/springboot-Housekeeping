package com.briup.jz.web.controller;

import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.service.IAccountEmployeeService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/15
 */
@RestController
@RequestMapping("/employee")
@Api(description = "员工账号管理接口")
public class AccountEmployeeController {
    @Autowired
    private IAccountEmployeeService accountEmployeeService;

    @ApiOperation("查询所有员工")
    @GetMapping("findAll")
    public Message findAll() {
        List<AccountEmployee> accountEmployees = accountEmployeeService.findAll();
        return MessageUtil.success("success", accountEmployees);

    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message finByid(
            @ApiParam(value = "主键", required = true)
            @RequestParam(value = "id") long id) {
        AccountEmployee accountEmployee = accountEmployeeService.findById(id);
        return MessageUtil.success("success", accountEmployee);
    }

    @ApiOperation("保存或更新员工信息")
    @PostMapping ("saveOrUpdate")
    public Message saveOrUpdate(AccountEmployee accountEmployee) throws Exception {
        accountEmployeeService.saveOrUpdate(accountEmployee);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation("通过id删除员工信息")
    @GetMapping("deleteById")
    public Message deleteById(@NotNull @RequestParam("id") Long id) throws Exception {

        accountEmployeeService.deleteById(id);
        return MessageUtil.success("删除成功");

    }
    //增加了批量删除员工信息
    @ApiOperation("批量删除员工信息")
    @PostMapping("batchDelete")
    public Message batchDelete(@NotNull(message = "id不能为空") Long[] ids) throws Exception {
        for (Long id: ids)
            accountEmployeeService.batchDelete(ids);
        return MessageUtil.success("成功");
    }
}
