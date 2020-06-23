package com.briup.jz.web.controller;

import com.briup.jz.bean.Comment;
import com.briup.jz.bean.CommentExample;
import com.briup.jz.bean.extend.CommentExtend;
import com.briup.jz.service.ICommentService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import com.sun.org.apache.bcel.internal.generic.MULTIANEWARRAY;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description ：评论控制器
 * @Author tj
 * @Date 2020/6/13
 */
@RestController
@RequestMapping("/comment")
@Api(description = "评论管理控制器")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    /**
     * 查询评论
     */
    @ApiOperation("查询所有评论信息")
    @GetMapping("findAll")
    public Message findAll(){
        List<Comment> list = commentService.findAll();
        return MessageUtil.success(list);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ApiOperation("通过id删除评论信息")
    @GetMapping("deleteById")
    public Message deleteById(Long id){
        commentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation("通过id查询评论信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "评论的id，唯一标识", required = true, paramType = "query")
    })
    @GetMapping("findById")
    public Comment findById(Long id){
        return commentService.findById(id);
    }

    /**
     * 添加评论
     */
    @ApiOperation("添加评论信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "无需填写", paramType = "query"),
            @ApiImplicitParam(name = "score", value = "请给此次服务评分", required = true, paramType = "query"),
            @ApiImplicitParam(name = "content", value = "请评论", required = true, paramType = "query"),
            @ApiImplicitParam(name = "commentTime", value = "无需填写", paramType = "query"),
    })
    @PostMapping("commit")
    public Message commit(Comment comment){
        commentService.commit(comment);
        return MessageUtil.success("添加评论成功");
    }

    /**
     * 按score查询评论
     */
    @ApiOperation("通过score查询评论信息")
    @GetMapping("findByScore")
    public Message findByScore(Integer score){
        List<Comment> list = commentService.findByScore(score);
        return MessageUtil.success("按评价等级查询成功",list);
    }
    @ApiOperation("查询所有评论信息并级联")
    @GetMapping("findAllWithChild")
    private Message findAllWithChild(){
        return MessageUtil.success(commentService.findAllWithChild());
    }
    @ApiOperation(value = "保存或者更新")
    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(@RequestBody Comment comment){
        commentService.saveOrUpdate(comment);
        return "保存成功";
    }

    @GetMapping("auditing")
    public Message auditing(long id){
        Comment comment=commentService.findById(id);
        System.out.println(comment.getStatus());
        comment.setStatus("审核通过");
        commentService.saveOrUpdate(comment);
        return MessageUtil.success("通过审核");
    }
    @GetMapping("refuseAuditing")
    public Message refuseAuditing(long id){
        Comment comment=commentService.findById(id);
        comment.setStatus("审核未通过");
        commentService.saveOrUpdate(comment);
        return MessageUtil.success("已经拒绝审核");
    }

//    @ApiOperation("审核评论")
//    @PostMapping("updateOrderStatus")
//    private Message updateOrderStatus(Long id,String status){
//        commentService.updateOrderStatus(id,status);
//        return MessageUtil.success("已修改修改评论状态");
//    }

}
