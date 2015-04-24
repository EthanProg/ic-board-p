package com.ic.manager.comment.service;

import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/22.
 */
public interface ICommentService
{
    public List<Map<String,Object>> queryCommentList(Map<String,Object> param_map);

    public Map<String,Object> queryComment(Map<String,Object> param_map);

    public Map<String,Object> addComment(Map<String,Object> param_map);

    public Map<String,Object> updateComment(Map<String,Object> param_map);

    public Map<String,Object> deleteComment(Map<String,Object> param_map);
}
