/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: WebSocket
 * Author:   Administrator
 * Date:     2018/9/21 0021 10:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuan.xianyu.common.Const;
import com.yuan.xianyu.config.WebsocketConfig;
import com.yuan.xianyu.dto.ChatDto;
import com.yuan.xianyu.pojo.Chat;
import com.yuan.xianyu.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/21 0021
 * @since 1.0.0
 */
@Component
@ServerEndpoint(value = "/webSocket", configurator = WebsocketConfig.class)
@Slf4j
public class WebSocket {

	private static IChatService chatService;

	private Session session;

	private User user;

	private static Map<Integer,WebSocket> webSocketMap = new HashMap<>();

	@Autowired
	public void setChatService(IChatService chatService) {
		WebSocket.chatService = chatService;
	}

	/**
	 * 主要用来监听连接建立，config用来获取WebsocketConfig中的配置信息
	 * @param session
	 * @param config
	 */
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		HttpSession httpSession = (HttpSession) config.getUserProperties().get(Const.SESSION_ID);
		this.session = session;
		this.user = (User) httpSession.getAttribute(Const.LOGIN_USER);
		if (user == null){
			return;
		}
		synchronized (WebSocket.class){
			webSocketMap.put(user.getId(), this);
		}
		List<Chat> chatList = chatService.listMyUnreadChat(this.user.getId());
		for (Chat item: chatList
			 ) {
			ChatDto chatDto = new ChatDto();
			chatDto.setUserId(user.getId());
			chatDto.setUserName(user.getUsername());
			chatDto.setMsg(item.getContent());
			sendMessage(chatDto);
		}
		chatService.updateRead(user.getId());
	}

	@OnClose
	public void onClose() {
		synchronized (WebSocket.class){
			webSocketMap.remove(this.user.getId());
		}
	}

	@OnError
	public void onError(Throwable e, Session session) {
		if (this.user != null){
			synchronized (WebSocket.class){
				webSocketMap.remove(this.user.getId());
			}
		}
		log.error("【websocket消息】连接出错或未关闭socket：" + e.getMessage());
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		log.info(message);
		Chat chat = null;
		Integer receiver = 0;
		try {
			ChatDto chatDto = new ObjectMapper().readValue(message, ChatDto.class);
			receiver = chatDto.getUserId();
			WebSocket webSocket =  webSocketMap.get(chatDto.getUserId());
			if (webSocket != null){
				chatDto.setUserName(this.user.getUsername());
				chatDto.setUserId(this.user.getId());
				if (webSocket.sendMessage(chatDto)){
					chat = new Chat(this.user.getId(),receiver,chatDto.getMsg(),1);
				}
			}
			if (chat == null){
				chat = new Chat(this.user.getId(),receiver,chatDto.getMsg(),0);
			}
			chatService.saveChat(chat);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public boolean sendMessage(Object o) {
		try {
			String msg = new ObjectMapper().writeValueAsString(o);
			this.session.getBasicRemote().sendText(msg);
			return true;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}


}