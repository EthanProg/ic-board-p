package com.ic.manager.comment.model;

/**
 * Created by xjw on 2015/4/22.
 */
public class Comment
{
    private String comment_id;
    private String user_id;
    private String advertise_id;
    //上级评论类型，用户or广告
    private String parent_type;
    private String  parent_user_id;
}
