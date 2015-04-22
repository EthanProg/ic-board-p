package com.ic.manager.comment.service;

import com.ic.core.model.CodeModel;
import com.ic.manager.comment.mapper.CommentServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/22.
 */
public class CommentServiceImpl implements ICommentService
{
    @Autowired
    private CommentServiceMapper commentServiceMapper;

    @Override
    public List<Map<String, Object>> queryCommentList(Map<String, Object> param_map)
    {
        return commentServiceMapper.queryCommentList(param_map);
    }

    @Override
    public Map<String, Object> queryComment(Map<String, Object> param_map)
    {
        return commentServiceMapper.queryComment(param_map);
    }

    @Override
    public Map<String, Object> addComment(Map<String, Object> param_map)
    {
        int nums = commentServiceMapper.addComment(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","新增评论成功");
        }
        else
        {

        }
        return rt_map;
    }

    @Override
    public Map<String, Object> updateComment(Map<String, Object> param_map)
    {
        int nums = commentServiceMapper.updateComment(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","更新评论成功");
        }
        else
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS_EMPTY);
            rt_map.put("msg","无此评论");
        }
        return rt_map;
    }

    @Override
    public Map<String, Object> deleteComment(Map<String, Object> param_map)
    {
        int nums = commentServiceMapper.deleteComment(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","删除评论成功");
        }
        else
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS_EMPTY);
            rt_map.put("msg","无此评论");
        }
        return rt_map;
    }
}
