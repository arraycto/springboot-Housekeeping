package com.briup.jz.service.impl;

import com.briup.jz.bean.Comment;
import com.briup.jz.bean.CommentExample;
import com.briup.jz.bean.extend.CommentExtend;
import com.briup.jz.dao.CommentMapper;
import com.briup.jz.dao.extend.CategoryExtendMapper;
import com.briup.jz.dao.extend.CommentExtendMapper;
import com.briup.jz.service.ICommentService;
import com.briup.jz.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description ：Comment实现类
 * @Author tj
 * @Date 2020/6/13
 */
@Service
public class CommentImpl implements ICommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private CommentExtendMapper commentExtendMapper;

    @Override
    public Comment findById(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void commit(Comment comment) throws CustomerException {
        commentMapper.insert(comment);
    }

    @Override
    public void deleteById(Long id) {
        commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentMapper.selectByExample(new CommentExample());
    }

    @Override
    public void saveOrUpdate(Comment comment) {
        if (comment.getId() != null){
            commentMapper.updateByPrimaryKey(comment);
            System.out.println("评论不存在");
        }else{
            commentMapper.insert(comment);System.out.println("评论已保存");
        }
    }

    @Override
    public List<Comment> findByScore(Integer score) {
        return commentExtendMapper.selectByScore(score);
    }

    @Override
    public List<CommentExtend> findAllWithChild() {
        return commentExtendMapper.selectAllWithChild();
    }

//    @Override
//    public void updateCommentStatus(Long id, String status) {
//        commentExtendMapper.updateCommentStatus(id,status);
//    }
}
