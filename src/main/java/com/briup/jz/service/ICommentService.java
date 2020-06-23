package com.briup.jz.service;

import com.briup.jz.bean.Comment;
import com.briup.jz.bean.extend.CommentExtend;
import com.briup.jz.utils.CustomerException;

import java.util.List;

/**
 * @Description ：评论接口
 * @Author tj
 * @Date 2020/6/13
 */
public interface ICommentService {
    /**
     * 按ID查询评论
     *
     */
    Comment findById(Long id);
    /**
     * 提交评论
     */
    void commit(Comment comment) throws CustomerException;

    void deleteById(Long id);
    /**
     * 查询所有评论
     */
    List<Comment> findAll();
    /**
     * 保存或更新
     */
    void saveOrUpdate(Comment comment);

    List<Comment> findByScore(Integer score);

    /**
     * 评论级联
     */
    List<CommentExtend> findAllWithChild();

//    void updateOrderStatus(Long id, String status);


}
