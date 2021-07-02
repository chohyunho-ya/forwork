package org.forwork.controller.chatting;

import java.util.List;
import java.util.Map;

import org.forwork.domain.Chatroom;
import org.forwork.dto.MessageCriteria;
import org.forwork.dto.MessageDto;
import org.forwork.service.chatting.ChattingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RequestMapping("/chatroom/*")
@AllArgsConstructor
@RestController
public class ChatroomController {

	private final ChattingService service;
	
	@GetMapping(value = "/{chatroomId}",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Chatroom> getChatroomName(@PathVariable String chatroomId) {
		Chatroom chatroom = new Chatroom();
		chatroom.setChatroom_name(service.findChatroomName(chatroomId));
		return new ResponseEntity<>(chatroom, HttpStatus.OK);
	}
	
	@GetMapping(value = "/member/{userId}",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<Chatroom>> getChatrooms(@PathVariable String userId) {
		List<Chatroom> chatrooms = service.findChatroomByMemberId(userId);
		return new ResponseEntity<>(chatrooms, HttpStatus.OK);
	}

	@PostMapping(value = "/new")
	public ResponseEntity<String> create(@RequestBody Map<String, List<String>> data) {
		String chatroomId = service.createChatroom(data.get("title").get(0), data.get("memberIds"));
		return new ResponseEntity<>(chatroomId, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{chatroomId}/member/{userId}")
	public ResponseEntity<String> deleteChatroomMemberRelation(@PathVariable String chatroomId, @PathVariable String userId) {
		service.deleteChatroomMemberRelation(chatroomId, userId);
		return new ResponseEntity<>("delete chatroom success", HttpStatus.OK);
	}
}
