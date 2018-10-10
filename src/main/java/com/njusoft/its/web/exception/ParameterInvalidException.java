package com.njusoft.its.web.exception;

import org.apache.log4j.Logger;

/**
 * 传递参数无效异常信息
 * Created by jijia on 2017/3/29.
 */
public class ParameterInvalidException extends Exception{

    private static final long serialVersionUID = -5355720426286569929L;

    private static Logger logger = Logger.getLogger(ParameterInvalidException.class);

    public ParameterInvalidException() {
        super("参数无效");
        logger.error("参数无效");
    }

    public ParameterInvalidException(String s) {
        super(s);
        logger.error(s);
    }
}
