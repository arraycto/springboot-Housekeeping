package com.briup.jz.bean.extend;

import com.briup.jz.bean.Category;
import com.briup.jz.bean.Product;

/**
 * @Description ：产品拓展类
 * @Author tj
 * @Date 2020/6/11
 */
public class ProductExtend extends Product {
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
