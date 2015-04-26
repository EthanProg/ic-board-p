package com.ic.core.model;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: CharlesSong
 * Date  : 2015/4/26
 */
public class DataResponse extends BaseResponse {
    private Map<String,Object> data;
    private List<Map<String,Object>> data_list;

    public DataResponse(Map data){
        super();
    }

    public DataResponse(String code, String msg){
        super(code,msg);
    }

    public DataResponse(String code,String msg,Map<String,Object> data){
        super(code,msg);
        this.data=data;
    }

    public DataResponse(String code,String msg,List<Map<String,Object>> data_list){
        super(code,msg);
        this.data_list=data_list;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public DataResponse setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public List<Map<String, Object>> getData_list()
    {
        return data_list;
    }

    public void setData_list(List<Map<String, Object>> data_list)
    {
        this.data_list = data_list;
    }
}
