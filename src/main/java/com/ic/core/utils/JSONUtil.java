package com.ic.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ic.core.model.CodeModel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.aspectj.apache.bcel.classfile.Code;

/**
 *功能：JSON转换工具类
 *@auther CharlesSong
 *@Date 2014年10月1日  
 *@Email Charles2Song@gmail.com
 **/
public class JSONUtil {
	
	/**
	 * json 对象转换成Map对象
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJSONObject2Map(JSONObject json){  
		Map<String, Object> map = new HashMap<String, Object>();  
        //最外层解析  
        for(Object k : json.keySet()){  
            Object v = json.get(k);   
            //如果内层还是数组的话，继续解析  
            if(v instanceof JSONArray){  
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
                Iterator<JSONObject> it = ((JSONArray)v).iterator();  
                while(it.hasNext()){  
                    JSONObject json2 = it.next();  
                    list.add(parseJSONObject2Map(json2));  
                }  
                map.put(k.toString(), list);  
            } else {  
                map.put(k.toString(), v);  
            }  
        }  
        return map;  
	}
	
	
	/**
	 * json字符串转换成Map对象
	 * @param jsonStr
	 * @return Map对象，根据code判断状态
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJSONString2Map(String jsonStr){  
        Map<String, Object> map = new HashMap<String, Object>();  
        //最外层解析  
        JSONObject json = null;
        try{
            json=JSONObject.fromObject(jsonStr);
            for(Object k : json.keySet()){
                Object v = json.get(k);
                //如果内层还是数组的话，继续解析
                if(v instanceof JSONArray){
                    List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                    Iterator<JSONObject> it = ((JSONArray)v).iterator();
                    while(it.hasNext()){
                        JSONObject json2 = it.next();
                        list.add(parseJSONString2Map(json2.toString()));
                    }
                    map.put(k.toString(), list);
                } else {
                    map.put(k.toString(), v);
                }
            }
            map.put("code", CodeModel.CODE_SUCCESS);
        }catch (Exception e){
            map.put("code", CodeModel.CODE_CONVERT_FAILURE);
            map.put("msg","数据格式错误");
        }
        return map;
    }  
	
	public static void main(String[] args){
		String json="{\"name\":\"离散\",\"list\":{\"list1\":\"1\",\"list2\":2}}";
		Map<String,Object> map=parseJSONString2Map(json);
		System.out.println(map.get("list"));
		JSONObject jn=JSONObject.fromObject(map);
		System.out.println(jn.toString());
	}
}
