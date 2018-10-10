package com.njusoft.its.domain.websocket;

import java.io.Serializable;

/** 
*
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月23日 上午11:50:38 
* @version 1.0 
* @since JDK 1.7
*/
public class WebSocketUserInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户名
	private String userName;
	//当前的线路编号
	private String curLineCodes;
	//用户相关的线路号
	private String connectedLineCodes;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getCurLineCodes() {
		return curLineCodes;
	}

	public void setCurLineCodes(String curLineCodes) {
		this.curLineCodes = curLineCodes;
	}

	public String getConnectedLineCodes() {
		return connectedLineCodes;
	}
	
	public void setConnectedLineCodes(String connectedLineCodes) {
		this.connectedLineCodes = connectedLineCodes;
	}

	@Override
	public String toString() {
		return "WebSocketUserInfo [curLineCodes=" + curLineCodes + ", connectedLineCodes=" + connectedLineCodes + "]";
	}
	
	
	
}
