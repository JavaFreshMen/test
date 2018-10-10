package com.njusoft.its.websocket;

import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.njusoft.its.datasource.db.push.WebSocketDBDataPushMgr;
import com.njusoft.its.domain.websocket.WebSocketSend;
import com.njusoft.its.domain.websocket.WebSocketUserInfo;
import com.njusoft.its.utils.GsonUtils;
import com.njusoft.its.utils.WebSocketReturnUtils;


/** 
*
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月19日 上午9:24:44 
* @version 1.0 
* @since JDK 1.7
*/
@ServerEndpoint(value="/emwebsocket")
@Component  //打包成war包放在tomcat下部署时需要注意注释
public class ExceptionMonitorWebSocket {
	
	private static final Logger logger = Logger.getLogger(ExceptionMonitorWebSocket.class);
	
	//username <--> web socket user info
	private static final ConcurrentHashMap<String,WebSocketUserInfo> webSocketUserInfosMap = new ConcurrentHashMap<>();
	//sessionid <--> session
	private static final ConcurrentHashMap<String,Session> sessionsMap = new ConcurrentHashMap<>();
	//message中的type表示数据类型
	private static final String WEB_SOCKET_MSG_TYPE = "type";
	
	/**
	 * 返回web socket 用户对象信息
	 * @return
	 */
	public static ConcurrentHashMap<String, WebSocketUserInfo> WebSocketUserInfos(){
		return webSocketUserInfosMap;
	}
	
	/**
	 * 推送基础数据
	 * @param webSocketUserInfo
	 * @param sessionId
	 * @return
	 */
	public static synchronized boolean pushBaseData(WebSocketUserInfo webSocketUserInfo,String sessionId){
		try {
			WebSocketDBDataPushMgr webSocketDBDataPushMgr = WebSocketDBDataPushMgr.getInstance();
			webSocketDBDataPushMgr.pushSystemConfigDBData(webSocketUserInfo, sessionId);
			webSocketDBDataPushMgr.pushBusDBData(webSocketUserInfo, sessionId);
		} catch (Exception e) {
			logger.error("推送基础数据异常",e);
		}
		return false;
	}
	
	/**
	 * 发送消息
	 * map key:lineCode
	 * @param message
	 * @return
	 */
	public synchronized static boolean sendMessage(WebSocketDataTypes dataType, String sessionId, WebSocketSend data){
		Session session = sessionsMap.get(sessionId);
		try {
			if(null != session && session.isOpen()){
				session.getBasicRemote().sendText(GsonUtils.toJson(WebSocketReturnUtils.mapOk(dataType.getName(), data)));
			}else{
				//清除失效的session
				sessionsMap.remove(sessionId);
				webSocketUserInfosMap.remove(sessionId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@OnOpen
	public void onOpen(Session session){
		logger.info("open web socket: "+session.getId());
		try {
			session.setMaxTextMessageBufferSize(10000);
			sessionsMap.put(session.getId(), session);
			session.getBasicRemote().sendText(GsonUtils.toJson(WebSocketReturnUtils.mapOk(WebSocketDataTypes.LOGIN.getName())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@OnMessage
	public void onMessage(String message, Session session){
		logger.info("web socket rev msg ["+message+"]");
		try {
			//消息处理和分发
			JsonObject jsonObject =  GsonUtils.parseJson(message);
			String type = jsonObject.get(WEB_SOCKET_MSG_TYPE).getAsString();
			if(type.equalsIgnoreCase(WebSocketDataTypes.CUR_LINES.getName())){
				//更新当前的socket关心的线路
				WebSocketUserInfo webSocketUserInfo = webSocketUserInfosMap.get(session.getId());
				if(null == webSocketUserInfo){
					webSocketUserInfo = new WebSocketUserInfo();
				}
				//更新信息
				String curLineCodes = jsonObject.get("lineCodes").getAsString();
				if(null != curLineCodes && !curLineCodes.isEmpty()){
					webSocketUserInfo.setCurLineCodes(curLineCodes);
				}
				webSocketUserInfosMap.put(session.getId(), webSocketUserInfo);
				System.out.println(webSocketUserInfo);
				//切换线路时推送基础数据
				pushBaseData(webSocketUserInfo, session.getId());
			}else if(type.equalsIgnoreCase(WebSocketDataTypes.CONNECTED_LINE.getName())){
				//更新当前的socket所关联的所有线路
				WebSocketUserInfo webSocketUserInfo = webSocketUserInfosMap.get(session.getId());
				if(null == webSocketUserInfo){
					webSocketUserInfo = new WebSocketUserInfo();
				}
				//更新信息
				String connectedLineCodes = jsonObject.get("connectedLineCodes").getAsString();
				if(null != connectedLineCodes && !connectedLineCodes.isEmpty()){
					webSocketUserInfo.setConnectedLineCodes(connectedLineCodes);
				}
				webSocketUserInfosMap.put(session.getId(), webSocketUserInfo);
				System.out.println(webSocketUserInfo);
				//切换线路时推送基础数据
				pushBaseData(webSocketUserInfo, session.getId());
			}else if(type.equalsIgnoreCase(WebSocketDataTypes.REAL_LOCATION.getName())){
				//实时车辆位置
				session.getBasicRemote().sendText(GsonUtils.toJson(WebSocketReturnUtils.mapOk(WebSocketDataTypes.REAL_LOCATION.getName())));
			}else if(type.equalsIgnoreCase(WebSocketDataTypes.REAL_EVENT.getName())){
				//实时事件
				session.getBasicRemote().sendText(GsonUtils.toJson(WebSocketReturnUtils.mapOk(WebSocketDataTypes.REAL_EVENT.getName())));
			}else if(type.equalsIgnoreCase(WebSocketDataTypes.LOGIN_USERNAME.getName())){
				//更新当前的socket所关联的所有线路
				WebSocketUserInfo webSocketUserInfo = webSocketUserInfosMap.get(session.getId());
				if(null == webSocketUserInfo){
					webSocketUserInfo = new WebSocketUserInfo();
				}
				//更新信息
				String userName = jsonObject.get("userName").getAsString();
				if(null != userName && !userName.isEmpty()){
					webSocketUserInfo.setUserName(userName);
				}
				webSocketUserInfosMap.put(session.getId(), webSocketUserInfo);
				System.out.println(webSocketUserInfo);
				//切换线路时推送基础数据
				pushBaseData(webSocketUserInfo, session.getId());
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@OnClose
	public void onClose(){
		logger.info("close web socket");
	}
	
	@OnError
	public void onError(Session session, Throwable error){
		logger.error("web socket 发生异常! "+error.getMessage());
		//清除对应的身份信息
		sessionsMap.remove(session.getId());
		webSocketUserInfosMap.remove(session.getId());
	}
	
}
