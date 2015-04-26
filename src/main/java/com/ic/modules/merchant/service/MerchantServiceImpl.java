package com.ic.modules.merchant.service;

//import com.ic.core.model.CodeModel;
import com.ic.core.model.Code;
import com.ic.modules.merchant.mapper.MerchantServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/22.
 */
@Service("merchantService")
public class MerchantServiceImpl implements IMerchantService
{
    @Autowired
    private MerchantServiceMapper merchantServiceMapper;

    @Override
    public List<Map<String, Object>> queryMerchantList(Map<String, Object> param_map) throws Exception
    {
        return merchantServiceMapper.queryMerchantList(param_map);
    }

    @Override
    public Map<String, Object> queryMerchant(Map<String, Object> param_map) throws Exception
    {
        return merchantServiceMapper.queryMerchant(param_map);
    }

    @Override
    public Map<String, Object> addMerchant(Map<String, Object> param_map) throws Exception
    {
        int nums = merchantServiceMapper.addMerchant(param_map);
        Map<String,Object> rt_map=new HashMap<String, Object>();
        if(nums>0){
            rt_map.put("code", Code.SUCCESS);
            rt_map.put("msg", Code.SUCCESS_MSG);
        }else{
            //如何提示？
            rt_map.put("code", Code.FAIL);
            rt_map.put("msg", Code.FAIL_MSG);
        }
        return rt_map;
    }

    @Override
    public Map<String, Object> updateMerchant(Map<String, Object> param_map) throws Exception
    {
        int nums = merchantServiceMapper.updateMerchant(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", Code.SUCCESS);
            rt_map.put("msg", Code.SUCCESS_MSG);
        }
        else
        {
            rt_map.put("code", Code.FAIL);
            rt_map.put("msg", Code.FAIL_MSG);
        }
        return rt_map;
    }

    @Override
    public Map<String, Object> deleteMerchant(Map<String, Object> param_map) throws Exception
    {
        int nums = merchantServiceMapper.deleteMerchant(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", Code.SUCCESS);
            rt_map.put("msg", Code.SUCCESS_MSG);
        }
        else
        {
            rt_map.put("code", Code.FAIL);
            rt_map.put("msg", Code.FAIL_MSG);
        }
        return rt_map;
    }
}
