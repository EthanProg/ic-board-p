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

}
