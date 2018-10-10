package com.njusoft.its.web.exception;

import org.apache.log4j.Logger;

/**
 * 系统内部出现 比如获取sql出现异常之类的
 * Created by jijia on 2017/3/29.
 */
public class SystemInnerException extends Exception{
    private static final long serialVersionUID = -7987787834634916541L;

    private static Logger logger = Logger.getLogger(SystemInnerException.class);

    public SystemInnerException() {
        super("系统内部异常");
        logger.error("系统内部异常");
    }

    public SystemInnerException(String s) {
        super(s);
        logger.error(s);
    }
}
