package com.ic.manager.advertise.service;

import com.ic.core.model.CodeModel;
import com.ic.manager.advertise.mapper.AdvertiseServiceMapper;
import com.ic.manager.merchant.mapper.MerchantServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/22.
 */
@Service("AdvertiseService")
public class AdvertiseServiceImpl implements IAdvertiseService
{
    @Autowired
    private AdvertiseServiceMapper advertiseServiceMapper;

    @Override
    public List<Map<String, Object>> queryAdvertiseList(Map<String, Object> param_map)
    {
        return advertiseServiceMapper.queryAdvertiseList(param_map);
    }

    @Override
    public Map<String, Object> queryAdvertise(Map<String, Object> param_map)
    {
        return advertiseServiceMapper.queryAdvertise(param_map);
    }

    @Override
    public Map<String, Object> addAdvertise(Map<String, Object> param_map)
    {
        int nums = advertiseServiceMapper.addAdvertise(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","新增广告成功");
        }
        else
        {

        }
        return rt_map;
    }

    @Override
    public Map<String, Object> updateAdvertise(Map<String, Object> param_map)
    {
        int nums = advertiseServiceMapper.updateAdvertise(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","更新广告成功");
        }
        else
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS_EMPTY);
            rt_map.put("msg","无此广告");
        }
        return rt_map;
    }

    @Override
    public Map<String, Object> deleteAdvertise(Map<String, Object> param_map)
    {
        int nums = advertiseServiceMapper.deleteAdvertise(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","删除广告成功");
        }
        else
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS_EMPTY);
            rt_map.put("msg","无此广告");
        }
        return rt_map;
    }

    @Override
    public List<Map<String, Object>> queryAdvertiseUnitList(Map<String, Object> param_map)
    {
        return advertiseServiceMapper.queryAdvertiseUnitList(param_map);
    }

    @Override
    public Map<String, Object> queryAdvertiseUnit(Map<String, Object> param_map)
    {
        return advertiseServiceMapper.queryAdvertiseUnit(param_map);
    }

    @Override
    public Map<String, Object> addAdvertiseUnit(Map<String, Object> param_map)
    {
        int nums = advertiseServiceMapper.addAdvertiseUnit(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","新增广告板块成功");
        }
        else
        {

        }
        return rt_map;
    }

    @Override
    public Map<String, Object> updateAdvertiseUnit(Map<String, Object> param_map)
    {
        int nums = advertiseServiceMapper.updateAdvertiseUnit(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","更新广告板块成功");
        }
        else
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS_EMPTY);
            rt_map.put("msg","无此广告板块");
        }
        return rt_map;
    }

    @Override
    public Map<String, Object> deleteAdvertiseUnit(Map<String, Object> param_map)
    {
        int nums = advertiseServiceMapper.deleteAdvertiseUnit(param_map);
        Map<String,Object> rt_map = new HashMap<String,Object>();
        if(nums > 0)
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS);
            rt_map.put("msg","删除广告板块成功");
        }
        else
        {
            rt_map.put("code", CodeModel.CODE_SUCCESS_EMPTY);
            rt_map.put("msg","无此广告板块");
        }
        return rt_map;
    }
}
