package com.ic.manager.advertise.service;

import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/22.
 */
public interface IAdvertiseService
{
    public List<Map<String,Object>> queryAdvertiseList(Map<String, Object> param_map);

    public Map<String,Object> queryAdvertise(Map<String, Object> param_map);

    public Map<String,Object> addAdvertise(Map<String, Object> param_map);

    public Map<String,Object> updateAdvertise(Map<String, Object> param_map);

    public Map<String,Object> deleteAdvertise(Map<String, Object> param_map);

    public List<Map<String,Object>> queryAdvertiseUnitList(Map<String, Object> param_map);

    public Map<String,Object> queryAdvertiseUnit(Map<String, Object> param_map);

    public Map<String,Object> addAdvertiseUnit(Map<String, Object> param_map);

    public Map<String,Object> updateAdvertiseUnit(Map<String, Object> param_map);

    public Map<String,Object> deleteAdvertiseUnit(Map<String, Object> param_map);

}
