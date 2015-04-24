package com.ic.manager.merchant.service;

import com.ic.core.model.CodeModel;
import com.ic.manager.merchant.mapper.MerchantServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/22.
 */
@Service("MerchantService")
public class MerchantServiceImpl implements IMerchantService
{
    @Autowired
    private MerchantServiceMapper merchantServiceMapper;

    @Override
    public List<Map<String, Object>> queryMerchantList(Map<String, Object> param_map)
    {
        return merchantServiceMapper.queryMerchantList(param_map);
    }

    @Override
    public Map<String, Object> queryMerchant(Map<String, Object> param_map)
    {
        return merchantServiceMapper.queryMerchant(param_map);
    }

    @Override
    public Map<String, Object> addMerchant(Map<String, Object> param_map)
    {
        int nums = merchantServiceMapper.addMerchant(param_map);
        Map<String,Object> rt_map=new HashMap<String, Object>();
        if(nums>0){
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","新增商户成功");
        }else{
            //如何提示？
        }
        return rt_map;
    }

    @Override
    public Map<String, Object> updateMerchant(Map<String, Object> param_map)
    {
        int nums = merchantServiceMapper.updateMerchant(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","更新商户成功");
        }
        else
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS_EMPTY);
            rt_map.put("msg","无此商户");
        }
        return rt_map;
    }

    @Override
    public Map<String, Object> deleteMerchant(Map<String, Object> param_map)
    {
        int nums = merchantServiceMapper.deleteMerchant(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","删除商户成功");
        }
        else
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS_EMPTY);
            rt_map.put("msg","无此商户");
        }
        return rt_map;
    }
}
