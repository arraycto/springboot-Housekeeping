package com.briup.jz.bean.extend;

import com.briup.jz.bean.Role;
import com.briup.jz.bean.User;

/**
 * @Description ：
 * @Author tj
 * @Date 2020/6/11
 */
public class UserExtend  extends User {
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
