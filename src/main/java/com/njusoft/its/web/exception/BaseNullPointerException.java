package com.njusoft.its.web.exception;


import org.apache.log4j.Logger;

/**
 * 空指针异常
 * Created by Administrator on 2017/1/9 0009.
 */
public class BaseNullPointerException extends Exception{

    private static final long serialVersionUID = 1504171003244818427L;
    private static Logger logger = Logger.getLogger(BaseNullPointerException.class);

    public BaseNullPointerException() {
        super("空指针异常");
        logger.error("空指针异常");
    }

    public BaseNullPointerException(String s) {
        super(s);
        logger.error(s);
    }
}
