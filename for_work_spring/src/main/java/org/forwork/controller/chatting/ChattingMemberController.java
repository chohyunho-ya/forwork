package org.forwork.controller.chatting;

import java.util.List;

import org.forwork.domain.Chatroom;
import org.forwork.domain.Member;
import org.forwork.dto.MemberDto;
import org.forwork.dto.MemberStatus;
import org.forwork.service.chatting.ChattingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RequestMapping("/chattingMember/*")
@AllArgsConstructor
@RestController
public class ChattingMemberController {
	
	private final ChattingService service;
	
	@GetMapping(value = "/chatroom/{chatroomId}",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<String>> getChatrooms(@PathVariable String chatroomId) {
		List<String> members = service.findMemberByChatroomId(chatroomId);
		return new ResponseEntity<>(members, HttpStatus.OK);
	}
	
	// TODO: 없앨 API	
	@GetMapping(value = "/all",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<Member>> getMembers(){
		return new ResponseEntity<List<Member>>(service.findAllMembers(), HttpStatus.OK);
	}

	@GetMapping(value = "/{memberId}",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<MemberDto> getMemberDetail(@PathVariable String memberId) {
		Member member = service.findMemberById(memberId);
		MemberDto memberDto = new MemberDto();
		memberDto.setMember_id(member.getMember_id());
		memberDto.setEmail(member.getEmail());
		memberDto.setName(member.getName());
		memberDto.setStatus(MemberStatus.getStatusDetailById(member.getStatus_id()).getStatusDetail());
		System.out.println(memberDto);
		return new ResponseEntity<>(memberDto, HttpStatus.OK);
	}
}
