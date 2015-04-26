package com.ic.core.impl;


import com.ic.core.enums.LogLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
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
     * 日志对象
     */
    protected Logger log = LoggerFactory.getLogger(getClass());


    public void debug(String string){
        if(log.isDebugEnabled()){
            log.debug(string);
        }
    }

    public void info(String string) {
        if (log.isInfoEnabled()) {
            log.info(string);
        }
    }

    public void error(String string) {
        if (log.isErrorEnabled()) {
            log.error(string);
        }
    }

}
