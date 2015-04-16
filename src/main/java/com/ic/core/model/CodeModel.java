package com.ic.core.model;

/**
 * Description:全局返回码说明
 * 约定：
 *  1.000以上的为成功相关状态码
 *  2.900以上的为失败相关状态码
 * Author: Charles
 * Date  : 2014/12/18
 */
public class CodeModel {
    /**
     * 成功状态码
     */
    public static String CODE_SUCCESS="000";

    /**
     * 数据库操作成功，但是没有变更数据
     */
    public static String CODE_SUCCESS_EMPTY="001";

    /**
     * 失败状态码
     */
    public static String CODE_FAILURE="999";

    /**
     * 参数为空状态码
     */
    public static String CODE_EMPTY_FAILURE="900";

    /**
     * 转换失败状态码
     */
    public static String CODE_CONVERT_FAILURE="901";


}
