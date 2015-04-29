package com.ic.modules.advertise.service;

import com.ic.core.model.Code;
import com.ic.modules.advertise.mapper.AdvertiseServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/28.
 */
@Service("advertiseService")
public class AdvertiseServiceImpl implements IAdvertiseService
{

    @Autowired
    private AdvertiseServiceMapper advertiseServiceMapper;

    @Override
    public Map<String, Object> queryAdvertise(Map<String, Object> param_map)
    {
        return advertiseServiceMapper.queryAdvertise(param_map);
    }

    @Override
    public List<Map<String, Object>> queryAdvertiseList(Map<String, Object> param_map)
    {
        return advertiseServiceMapper.queryAdvertiseList(param_map);
    }


    @Override
    public Map<String, Object> addAdvertise(Map<String, Object> param_map)
    {
        Map<String,Object> ret_map = new HashMap<String,Object>();

        //1.新增广告

        //2.新增商家积分

        return ret_map;
    }

    @Override
    public Map<String, Object> updateAdvertise(Map<String, Object> param_map)
    {
        Map<String,Object> ret_map = new HashMap<String,Object>();
        int num = advertiseServiceMapper.updateAdvertise(param_map);
        if(num > 0)
        {
            ret_map.put("code", Code.SUCCESS);
            ret_map.put("msg", Code.SUCCESS_MSG);
        }
        else
        {
            ret_map.put("code", Code.FAIL);
            ret_map.put("msg", Code.FAIL_MSG);
        }
        return ret_map;
    }

    @Override
    public Map<String, Object> deleteAdvertise(Map<String, Object> param_map)
    {
        Map<String,Object> ret_map = new HashMap<String,Object>();
        int num = advertiseServiceMapper.deleteAdvertise(param_map);
        if(num > 0)
        {
            ret_map.put("code", Code.SUCCESS);
            ret_map.put("msg", Code.SUCCESS_MSG);
        }
        else
        {
            ret_map.put("code", Code.FAIL);
            ret_map.put("msg", Code.FAIL_MSG);
        }
        return ret_map;
    }
}
