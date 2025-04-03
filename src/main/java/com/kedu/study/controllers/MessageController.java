package com.kedu.study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.kedu.study.service.BoardService;

@Controller
public class MessageController {
	@Autowired private BoardService bServ;
	
	@MessageMapping("/send")  // 클라이언트가 보낼 경로
    @SendTo("/topic/messages") // 메시지를 구독하는 경로
    public String sendMessage(String message) {
        System.out.println("Received message: " + message);
        return message; // 클라이언트에게 다시 전송
    }

}
