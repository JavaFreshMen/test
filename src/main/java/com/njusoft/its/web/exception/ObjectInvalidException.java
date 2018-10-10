package com.njusoft.its.web.exception;

import org.apache.log4j.Logger;

/**
 * 对象无效异常
 * Created by jijia on 2017/3/29.
 */
public class ObjectInvalidException extends Exception{

    private static final long serialVersionUID = -222591675187144714L;

    private static Logger logger = Logger.getLogger(ObjectInvalidException.class);

    public ObjectInvalidException() {
        super("对象无效");
        logger.error("对象无效");
    }

    public ObjectInvalidException(String s) {
        super(s);
        logger.error(s);
    }
}
