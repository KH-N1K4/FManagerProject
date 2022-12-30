package com.manager.freelancer.common.message.model.websocket;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChattingWebsocketHandler extends TextWebSocketHandler{

	private Logger logger = LoggerFactory.getLogger(ChattingWebsocketHandler.class);
}
