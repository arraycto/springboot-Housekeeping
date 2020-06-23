package com.briup.jz.web.controller;

import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.bean.AccountSystem;
import com.briup.jz.service.IAccountEmployeeService;
import com.briup.jz.service.IAccountSystemService;
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
@RequestMapping("/system")
@Api(description = "管理员账号管理接口")
public class AccountSystemController {
    @Autowired
    private IAccountSystemService accountSystemService;

    @ApiOperation("查询所有管理员")
    @GetMapping("findAll")
    public Message findAll() {
        List<AccountSystem> accountSystems = accountSystemService.findAll();
        return MessageUtil.success("success", accountSystems);

    }

    @ApiOperation("通过id查询管理员")
    @GetMapping("findById")
    public Message finByd(
            @ApiParam(value = "主键", required = true)
            @RequestParam(value = "id") long id) {
        AccountSystem accountSystem = accountSystemService.findById(id);
        return MessageUtil.success("success", accountSystem);
    }

    @ApiOperation("保存或更新管理员信息")
    @PostMapping ("saveOrUpdate")
    public Message saveOrUpdate(AccountSystem accountSystem) throws Exception {
        accountSystemService.saveOrUpdate(accountSystem);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation("通过id删除管理员信息")
    @GetMapping("deleteById")
    public Message deleteById(@NotNull @RequestParam("id") Long id) throws Exception {

        accountSystemService.deleteById(id);
        return MessageUtil.success("删除成功");

    }

}
