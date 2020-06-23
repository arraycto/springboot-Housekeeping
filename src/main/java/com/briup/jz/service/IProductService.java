package com.briup.jz.service;

import com.briup.jz.bean.Product;
import com.briup.jz.bean.ProductExample;
import com.briup.jz.bean.extend.ProductExtend;
import com.briup.jz.utils.CustomerException;
import sun.dc.pr.PRError;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void saveOrUpdate(Product product) throws CustomerException;

    void deleteById(Long id) throws CustomerException;

    List<ProductExtend> findAllWithCategory();
}
