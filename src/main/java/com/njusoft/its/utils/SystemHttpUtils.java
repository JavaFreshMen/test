package com.njusoft.its.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http utils 工具类
 * Created by jia ji on 2017/6/1.
 */
public class SystemHttpUtils {
	private final static Logger logger = LoggerFactory.getLogger(SystemHttpUtils.class);

    /**
     * 发起HttpGet请求
     * @param url 请求url
     * @return
     */
    public static String sendGet(String url){
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder sBuilder = new StringBuilder();
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("content-type","application/x-www-form-urlencoded");
            httpGet.addHeader("Accept", "application/json");
            HttpResponse httpResponse = httpClient.execute(httpGet);
            //连接成功
            logger.info("HTTP RESPONSE STATUSCODE:【{}】",httpResponse.getStatusLine().getStatusCode());
            if(200 == httpResponse.getStatusLine().getStatusCode()){
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
                br = new BufferedReader(new InputStreamReader(is,"utf-8"));
                String tempStr;
                while ((tempStr = br.readLine()) != null) {
                    sBuilder.append(tempStr);
                }
                br.close();
                is.close();
            }
            logger.info("HTTP RESPONSE DATA【{}】",sBuilder.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
			if(null != httpClient){
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				httpClient = null;
			}
		}
        return sBuilder.toString();
    }
    
    /**
     * 发起POST请求
     * @param url
     * @return
     */
    public static String sendPost(String url,List<NameValuePair> nameValuePairs){
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder sBuilder = new StringBuilder();
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("content-type","application/x-www-form-urlencoded");
            httpPost.addHeader("Accept", "application/json");
            if(null != nameValuePairs && !nameValuePairs.isEmpty()){
            	 //url格式编码
                UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
                httpPost.setEntity(uefEntity);
            }
            logger.info("POST 请求...【{}】",httpPost.getURI());
            HttpResponse httpResponse = httpClient.execute(httpPost);
            //连接成功
            logger.info("HTTP RESPONSE STATUSCODE:【{}】",httpResponse.getStatusLine().getStatusCode());
            if(200 == httpResponse.getStatusLine().getStatusCode()){
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
                br = new BufferedReader(new InputStreamReader(is,"utf-8"));
                String tempStr;
                while ((tempStr = br.readLine()) != null) {
                    sBuilder.append(tempStr);
                }
                br.close();
                is.close();
            }
            logger.info("HTTP RESPONSE DATA【{}】",sBuilder.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
			if(null != httpClient){
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				httpClient = null;
			}
		}
        return sBuilder.toString();
    }

}
