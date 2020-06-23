package com.briup.jz.bean.extend;

import com.briup.jz.bean.Category;

import java.util.List;

/**
 * @Description ：栏目扩展类
 * @Author tj
 * @Date 2020/6/11
 */
public class CategoryExtend extends Category {
    private List<Category> children;

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
