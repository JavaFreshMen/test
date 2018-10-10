package com.njusoft.its.utils;


import java.util.List;

/**
 * 数据库相关工具类
 * Created by Administrator on 2017/3/31 0031.
 */
public class DBUtils {
    /**
     * 构造sql中字段类型为String的in的参数
     * @param code 包含分隔符的字符串
     * @param splitstr 分隔符
     * @return
     * 入参   code   a,b,c
     *        splitstr   ,
     * 出参  'a','b','c'
     */
    public static String buildInParameters(String code,String splitstr) throws Exception{
        if (null == code || code.trim().equals("")){
            return null;
        }
        String[] codes=code.split(splitstr);
        StringBuffer codeBuffer=new StringBuffer("");
        for (int i=0;i<codes.length;i++){
            codeBuffer.append("'").append(codes[i]).append("'");
            if ( i< codes.length - 1){
                codeBuffer.append(",");
            }
        }
        return codeBuffer.toString();
    }

    /**
     * 构造sql中字段类型为String的in的参数
     * @param codes
     * @return
     * @throws ParameterInvalidException
     */
    public static String buildInParameters(List<String> codes) throws Exception{
        StringBuffer codeBuffer=new StringBuffer("");
        for (int i=0;i<codes.size();i++){
            codeBuffer.append("'").append(codes.get(i)).append("'");
            if ( i< codes.size() - 1){
                codeBuffer.append(",");
            }
        }
        return codeBuffer.toString();
    }
}
