package org.forwork.service.chatting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.forwork.config.RedisConfig;
import org.forwork.domain.Chatroom;
import org.forwork.domain.ChatroomMemberRelation;
import org.forwork.domain.Member;
import org.forwork.domain.MemberMessageRelation;
import org.forwork.domain.Message;
import org.forwork.dto.MessageCriteria;
import org.forwork.dto.MessageDto;
import org.forwork.dto.MessageSearchDto;
import org.forwork.mapper.ChattingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class ChattingServiceImpl implements ChattingService {
	private ChattingMapper mapper;
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public List<ChatroomMemberRelation> findChatroomMemberRelations() {
		// TODO Auto-generated method stub
		return mapper.getChatroomMemberRelation();
	}

	@Transactional(readOnly = true)
	@Override
	public String createMessage(Message message) {
		// 메세지 저장
		if (message.getFile_path() == null) {
			message.setFile_path("");
		}
		mapper.insertMessage(message);

		// 안읽음 상태 생성
		MemberMessageRelation status = new MemberMessageRelation();
		status.setMessage_id(message.getMessage_id());
		List<String> memberIds = mapper.getMemberByChatroomId(message.getChatroom_id());
		memberIds.forEach(memberId -> {
			if (!memberId.equals(message.getSender())) {
				status.setMember_id(memberId);
				mapper.insertUnreadStatus(status);
			}
		});

		// 캐시 업데이트
		ValueOperations<String, Object> vop = redisTemplate.opsForValue();
		String key = "chatroom:" + message.getChatroom_id() + ":last:message";
		vop.set(key, message);

		return message.getMessage_id();
	}

	@Override
	public List<MessageDto> findMessageByChatroomId(String chatroomId) {
		// TODO Auto-generated method stub
		return mapper.getMessageByChatroomId(chatroomId);
	}

	@Override
	public List<Chatroom> findChatroomByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return mapper.getChatroomByMemberId(memberId);
	}

	@Override
	public Member findMemberById(String memberId) {
		// TODO Auto-generated method stub
		return mapper.getMemberById(memberId);
	}

	@Transactional
	@Override
	public List<Message> findLastMessagePerChatroomByMemberId(String memberId) {
		// TODO Auto-generated method stub
		List<Message> messages = new ArrayList<Message>();
		ValueOperations<String, Object> vop = redisTemplate.opsForValue();
		List<Chatroom> chatrooms = mapper.getChatroomByMemberId(memberId);
		for (Chatroom chatroom : chatrooms) {
			String key = "chatroom:" + chatroom.getChatroom_id() + ":last:message";
			Message lastMessageFromCache = (Message) vop.get(key);
			log.info("cache: " + lastMessageFromCache);
			if (lastMessageFromCache != null) {
				messages.add(lastMessageFromCache);
			} else {
				Message lastMessageFromDB = mapper.getLastMessageByChatroomId(chatroom.getChatroom_id());
				if (lastMessageFromDB == null) {
					Message msg = new Message();
					msg.setChatroom_id(chatroom.getChatroom_id());
					msg.setMessage("대화를 시작해보세요.");
					msg.setSend_time("");
					vop.set(key, msg);
					messages.add(msg);
				} else {
					vop.set(key, lastMessageFromDB);
					messages.add(lastMessageFromDB);
				}
			}
		}
		log.info("all last messages: " + messages);

		return messages;
	}

	@Override
	public String findChatroomName(String chatroomId) {
		// TODO Auto-generated method stub
		return mapper.getChatroomName(chatroomId);
	}

	@Override
	public void updateReadStatus(String messageId, String memberId) {
		// TODO Auto-generated method stub
		MemberMessageRelation status = new MemberMessageRelation();
		status.setMember_id(memberId);
		status.setMessage_id(messageId);
		mapper.updateReadStatus(status);
	}

	@Override
	public void updateReadAll(String chatroomId, String memberId) {
		// TODO Auto-generated method stub
		ChatroomMemberRelation chatroomMember = new ChatroomMemberRelation();
		chatroomMember.setChatroom_id(chatroomId);
		chatroomMember.setMember_id(memberId);
		mapper.updateReadStatusPerChatroomByMemberId(chatroomMember);
	}

	@Override
	public List<String> findMemberByChatroomId(String chatroomId) {
		// TODO Auto-generated method stub
		return mapper.getMemberByChatroomId(chatroomId);
	}

	@Override
	public List<Map<String, String>> findUnreadCountPerChatroomByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return mapper.countUnreadPerChatroomByMemberId(memberId);
	}

	@Override
	public List<MessageDto> findMessageByChatroomIdWithPaging(MessageCriteria cri, String chatroomId) {
		// TODO Auto-generated method stub
		List<MessageDto> messages = mapper.getMessageByChatroomIdWithPaging(cri, chatroomId);
		Collections.reverse(messages);
		return messages;
	}

	@Override
	public List<Member> findAllMembers() {
		// TODO Auto-generated method stub
		return mapper.getAllMembers();
	}

	@Transactional(readOnly = true)
	@Override
	public String createChatroom(String chatroomTitle, List<String> memberIds) {
		// TODO Auto-generated method stub
		Chatroom chatroom = new Chatroom();
		chatroom.setChatroom_name(chatroomTitle);
		mapper.createChatroom(chatroom);
		ChatroomMemberRelation relation = new ChatroomMemberRelation();
		relation.setChatroom_id(chatroom.getChatroom_id());
		memberIds.forEach(id -> {
			relation.setMember_id(id);
			mapper.insertChatroomMemberRelation(relation);
		});
		return chatroom.getChatroom_id();
	}

	@Override
	public void deleteChatroomMemberRelation(String chatroomId, String memberId) {
		// TODO Auto-generated method stub
		ChatroomMemberRelation relation = new ChatroomMemberRelation();
		relation.setChatroom_id(chatroomId);
		relation.setMember_id(memberId);
		mapper.deleteChatroomMemberRelation(relation);
	}

	@Override
	public List<MessageSearchDto> searchMessage(String query, String chatroomId, String amount) {
		// TODO Auto-generated method stub
		query = "%" + query + "%";
		List<Map<String, String>> messageIdRowNums = mapper.searchMessage(query, chatroomId);
		List<MessageSearchDto> dtos = new ArrayList<MessageSearchDto>();
		
		messageIdRowNums.forEach(pair -> {
			MessageSearchDto dto = new MessageSearchDto();
			dto.setMessageId(String.valueOf(pair.get("messageId")));
			dto.calculatePageNumByRownum(String.valueOf(pair.get("rownum")), amount);
			dtos.add(dto);
		});
		
		log.info(dtos);
		
		return dtos;
	}
}
