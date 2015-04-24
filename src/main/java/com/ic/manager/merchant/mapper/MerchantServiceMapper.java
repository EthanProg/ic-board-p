package com.ic.manager.merchant.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/21.
 */
public interface MerchantServiceMapper
{
    /**
     * 功能：查询商家列表
     * @param params
     * @return
     */
    public List<Map<String,Object>> queryMerchantList(Map<String,Object> params);

    /**
     * 功能：查询单个商家
     * @param params
     * @return
     */
    public Map<String,Object> queryMerchant(Map<String,Object> params);

    /**
     * 功能：添加商家
     * @param params
     * @return
     */
    public Integer addMerchant(Map<String,Object> params);

    /**
     * 功能：删除商家
     * @param params
     * @return
     */
    public Integer deleteMerchant(Map<String,Object> params);

    /**
     * 功能：更新商家
     * @param params
     * @return
     */
    public Integer updateMerchant(Map<String,Object> params);

}
