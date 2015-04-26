package com.ic.modules.merchant.service;

import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/22.
 */
public interface IMerchantService
{
    public List<Map<String,Object>> queryMerchantList(Map<String, Object> param_map) throws Exception;

    public Map<String,Object> queryMerchant(Map<String, Object> param_map) throws Exception;

    public Map<String,Object> addMerchant(Map<String, Object> param_map) throws Exception;

    public Map<String,Object> updateMerchant(Map<String, Object> param_map) throws Exception;

    public Map<String,Object> deleteMerchant(Map<String, Object> param_map) throws Exception;

}
