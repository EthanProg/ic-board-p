package com.ic.modules.merchant.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/21.
 */
public interface MerchantServiceMapper
{
    /**
     * 功能：查询商家列表
     * @param param_map
     * @return
     */
    public Map<String,Object> queryMerchant(Map<String,Object> param_map);

    /**
     * 功能：查询单个商家
     * @param param_map
     * @return
     */
    public List<Map<String,Object>> queryMerchantList(Map<String, Object> param_map);

    /**
     * 功能：添加商家
     * @param param_map
     * @return
     */
    public Integer addMerchant(Map<String, Object> param_map);

    /**
     * 功能：删除商家
     * @param param_map
     * @return
     */
    public Integer deleteMerchant(Map<String, Object> param_map);

    /**
     * 功能：更新商家
     * @param param_map
     * @return
     */
    public Integer updateMerchant(Map<String, Object> param_map);

}
