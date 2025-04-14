package com.kedu.study.controllers;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.kedu.study.dto.MessageDTO;
import com.kedu.study.service.MessageService;

@Controller
public class MessageController {
	@Autowired 
	private MessageService mServ;
	
	@MessageMapping("/send/{seq}")  // 클라이언트가 보낼 경로
    @SendTo("/topic/messages/{seq}") // 메시지를 구독하는 경로
    public MessageDTO sendMessage(@DestinationVariable int seq ,MessageDTO message) {
        message.setSend_date(new Timestamp(System.currentTimeMillis()));
   
        mServ.saveMessage(message);
        
        return message; // 클라이언트에게 다시 전송
    }
	

}
