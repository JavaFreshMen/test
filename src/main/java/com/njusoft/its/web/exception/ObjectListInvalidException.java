package com.njusoft.its.web.exception;

import org.apache.log4j.Logger;

/**
 * 对象list数组无效
 * Created by jijia on 2017/3/29.
 */
public class ObjectListInvalidException extends Exception{

    private static final long serialVersionUID = -5881943898656745205L;

    private static Logger logger = Logger.getLogger(ObjectListInvalidException.class);

    public ObjectListInvalidException() {
        super("对象list数组无效");
        logger.error("对象list数组无效");
    }

    public ObjectListInvalidException(String s) {
        super(s);
        logger.error(s);
    }
}
