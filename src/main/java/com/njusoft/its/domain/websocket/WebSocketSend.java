package com.njusoft.its.domain.websocket;

import java.util.ArrayList;
import java.util.List;

public class WebSocketSend {
	
	private String lineCode;
	private List<? extends Object> list = new ArrayList<>();
	
	public String getLineCode() {
		return lineCode;
	}
	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}
	public List<? extends Object> getList() {
		return list;
	}
	public void setList(List<? extends Object> list) {
		this.list = list;
	}
	
	public WebSocketSend(String lineCode, List<? extends Object> list) {
		super();
		this.lineCode = lineCode;
		this.list = list;
	}
	
	public WebSocketSend() {}

}
