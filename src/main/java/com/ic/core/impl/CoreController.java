package com.ic.core.impl;


import com.ic.core.enums.LogLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;

/**
 * Description:所有Controller的基类
 * 约定：
 *      1.除方法特殊说明外，其他的所有的参数以json字符串的形式，以inJson参数输入
 * Author: Charles
 * Date  : 2014/12/16
 */
public abstract class CoreController implements Serializable {
    private Log log = LogFactory.getLog(this.getClass().getName());

    /**
     * 功能：输出日志信息，每个Controller中不必再次获得Log对象
     * @param logLevel 要输出的日志级别
     * @param obj 要输出的日志内容
     */
    public void logMessage(LogLevel logLevel,Object obj){
        switch (logLevel){
            case DEBUG:
                log.debug(obj);
                break;
            case INFO:
                log.info(obj);
                break;
            case WARN:
                log.warn(obj);
                break;
            case TRACE:
                log.trace(obj);
                break;
            case ERROR:
                log.error(obj);
                break;
        }
    }
}
