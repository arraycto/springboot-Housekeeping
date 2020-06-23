package com.briup.jz.bean.extend;

import com.briup.jz.bean.Comment;

import java.util.List;

/**
 * @Description ：评论拓展类
 * @Author tj
 * @Date 2020/6/13
 */
public class CommentExtend extends Comment {
    public static final String FAILED = "审核不通过";
    public static final String APPROVED = "审核通过";
    public static final String NOTAPPROVED = "未审核";

    private List<CommentExtend> children;

    public List<CommentExtend> getChildren() {
        return children;
    }

    public void setChildren(List<CommentExtend> children) {
        this.children = children;
    }
}
