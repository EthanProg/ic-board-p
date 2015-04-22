package com.ic.manager.advertise.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/21.
 */
public interface AdvertiseServiceMapper
{
    /**
     * 功能：查询广告列表
     * @param params
     * @return
     */
    public List<Map<String,Object>> queryAdvertiseList(Map<String, Object> params);

    /**
     * 功能：查询广告商家
     * @param params
     * @return
     */
    public Map<String,Object> queryAdvertise(Map<String, Object> params);

    /**
     * 功能：添加广告
     * @param params
     * @return
     */
    public Integer addAdvertise(Map<String, Object> params);

    /**
     * 功能：更新广告
     * @param params
     * @return
     */
    public Integer updateAdvertise(Map<String, Object> params);

    /**
     * 功能：删除广告
     * @param params
     * @return
     */
    public Integer deleteAdvertise(Map<String, Object> params);

    public List<Map<String,Object>> queryAdvertiseUnitList(Map<String,Object> params);

    public Map<String,Object> queryAdvertiseUnit(Map<String,Object> params);

    public Integer addAdvertiseUnit(Map<String,Object> params);

    public Integer deleteAdvertiseUnit(Map<String,Object> params);

    public Integer updateAdvertiseUnit(Map<String,Object> params);

}
