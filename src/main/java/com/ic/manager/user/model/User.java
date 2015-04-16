package com.ic.manager.user.model;

import com.ic.core.model.CoreModel;

import java.util.Date;

/**
 * Description:用户的基本属性
 * Author: Charles
 * Date  : 2014/12/13
 */
public class User extends CoreModel {
    /**
     * 用户编码
     */
    private String userId;
    /**
     * 用户登录名称，可以是邮箱等
     */
    private String userName;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 用户出生日期
     */
    private Date userBorn;

    /**
     * 用户邮箱
     */
    private String userMail;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 最后登录时间
     */
    private Date lastTime;

    /**
     * 用户登录密码
     */
    private String userPass;

    /**
     * 安全问题
     */
    private String userQuestion;

    /**
     * 问题答案
     */
    private String userAnswer;

    /**
     * 用户地址
     */
    private String userAddr;

    /**
     * 登录次数
     */
    private Integer loginTimes;

    /**
     * 用户所属公司编码，默认default
     */
    private String comId;

    /**
     * 用户所属公司名称
     */
    private String comName;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 用户状态 1（正常）2（禁用）3（锁定）
     */
    private String userStatus;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBorn() {
        return userBorn;
    }

    public void setUserBorn(Date userBorn) {
        this.userBorn = userBorn;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
