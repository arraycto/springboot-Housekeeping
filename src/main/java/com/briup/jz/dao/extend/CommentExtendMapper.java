package com.briup.jz.dao.extend;

import com.briup.jz.bean.Comment;
import com.briup.jz.bean.extend.CommentExtend;
import com.briup.jz.bean.extend.OrderExtend;

import java.util.List;

/**
 * @Description ：评论接口拓展实现类
 * @Author tj
 * @Date 2020/6/13
 */
public interface CommentExtendMapper {
    List<CommentExtend> selectAllWithChild();
    List<Comment> selectByScore(Integer score);
//    void updateCommentStatus(Long id, String status);
}
