/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: WebsocketConfig
 * Author:   Administrator
 * Date:     2018/9/21 0021 10:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.config;

import com.yuan.xianyu.common.Const;
import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/21 0021
 * @since 1.0.0
 */
@Configuration
public class WebsocketConfig extends ServerEndpointConfig.Configurator{

	/**
	* @Description: 修改握手,就是在握手协议建立之前修改其中携带的内容
	* @Param:
	* @return:
	* @Author: yuan
	* @Date: 2018/9/21 0021
	*/
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		/*如果没有监听器,那么这里获取到的HttpSession是null*/
		StandardSessionFacade ssf = (StandardSessionFacade) request.getHttpSession();
		if (ssf != null) {
			javax.servlet.http.HttpSession session = (HttpSession) request.getHttpSession();
			sec.getUserProperties().put(Const.SESSION_ID, session);
		}
		super.modifyHandshake(sec, request, response);
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		//这个对象说一下，貌似只有服务器是tomcat的时候才需要配置,具体我没有研究
		return new ServerEndpointExporter();
	}

}