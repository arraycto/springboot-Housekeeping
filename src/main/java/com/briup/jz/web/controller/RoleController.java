package com.briup.jz.web.controller;

import com.briup.jz.bean.Role;
import com.briup.jz.service.IRoleService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
 * @Date 2020/6/15
 */
@RestController
@RequestMapping("/role")
@Api(description = "角色管理接口")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "查询所有角色")
    @GetMapping("findAll")
    public Message findAll() {
        List<Role> list = roleService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id查找角色")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("findById")
    public Message findById(long id) {

        return MessageUtil.success(roleService.findById(id));
    }

    @ApiOperation(value = "添加或通过id修改角色")
    @PostMapping("savOrUpdate")
    public Message saveOrEdit(Role role) {
        roleService.saveOrEdit(role);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation(value = "通过id删除角色")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("deleteById")
    public Message delById(long id) {
        roleService.delById(id);
        return MessageUtil.success("删除成功");
    }

}
