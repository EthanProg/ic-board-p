package com.ic.core.base;


import com.ic.core.mapper.JsonMapper;
import com.ic.core.model.DataResponse;
import com.ic.core.utils.DateUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Description:所有Controller的基类
 * 约定：
 *      1.除方法特殊说明外，其他的所有的参数以json字符串的形式，以inJson参数输入
 * Author: Charles
 * Date  : 2014/12/16
 */
public abstract class CoreController implements Serializable {

    /**
     * 客户端返回JSON字符串
     *
     * @param response
     * @param object
     * @return
     */
    protected String renderString(HttpServletResponse response, Object object) {
        return renderString(response, JsonMapper.toJsonString(object), "application/json");
    }


    protected String renderData(HttpServletResponse response,String code,String msg, Map<String,Object> data) {
        DataResponse dr=new DataResponse(code,msg,data);
        dr.setTranstime(null);
        return renderString(response, JsonMapper.toJsonString(dr), "application/json");
    }

    /**
     * 客户端返回字符串
     *
     * @param response
     * @param string
     * @return
     */
    protected String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            return null;
        } catch (IOException e) {
            return null;
        }
    }

}
