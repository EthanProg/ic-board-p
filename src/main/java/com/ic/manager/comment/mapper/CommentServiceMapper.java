package com.ic.manager.comment.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/22.
 */
public interface CommentServiceMapper
{
    public List<Map<String,Object>> queryCommentList(Map<String,Object> param_map);

    public Map<String,Object> queryComment(Map<String,Object> param_map);

    public Integer addComment(Map<String,Object> param_map);

    public Integer updateComment(Map<String,Object> param_map);

    public Integer deleteComment(Map<String,Object> param_map);

}
