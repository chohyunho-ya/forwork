package org.forwork.controller.chatting;

import org.forwork.dto.MessageDto;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MessageRelayController {
	
	// 각 사용자들은 자기가 속한 채팅방을 구독 (/topic/chatroom/{id})
	// 메세지 종류 : 채팅방 입장,퇴장 메세 / 채팅 메세지
	
    @MessageMapping("/chatroom/{chatroomId}")
    @SendTo("/topic/chatroom/{chatroomId}")
    public MessageDto sendToChatroom(@DestinationVariable String chatroomId, MessageDto message) throws Exception {
        return message;
    }
    
    @MessageMapping("/user/{userId}")
    @SendTo("/topic/user/{userId}")
    public MessageDto sendToUser(@DestinationVariable String userId, MessageDto message) throws Exception {
        return message;
    }
    
}