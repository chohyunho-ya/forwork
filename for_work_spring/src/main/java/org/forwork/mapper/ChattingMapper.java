package org.forwork.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.forwork.domain.Chatroom;
import org.forwork.domain.ChatroomMemberRelation;
import org.forwork.domain.Member;
import org.forwork.domain.MemberMessageRelation;
import org.forwork.domain.Message;
import org.forwork.dto.MessageCriteria;
import org.forwork.dto.MessageDto;

public interface ChattingMapper {
	List<ChatroomMemberRelation> getChatroomMemberRelation();
	int insertMessage(Message message);
	List<MessageDto> getMessageByChatroomId(String chatroomId);
	List<Chatroom> getChatroomByMemberId(String memberId);
	Member getMemberById(String memberId);
//	List<Message> getLastMessagePerChatroomByMemberId(String memberId);
	Message getLastMessageByChatroomId(String chatroomId);
	String getChatroomName(String chatroomId);
	void updateReadStatus(MemberMessageRelation status);
	void insertUnreadStatus(MemberMessageRelation status);
	List<String> getMemberByChatroomId(String chatroomId);
	void updateReadStatusPerChatroomByMemberId(ChatroomMemberRelation chatroomMember);
	List<Map<String, String>> countUnreadPerChatroomByMemberId(String memberId);
	List<MessageDto> getMessageByChatroomIdWithPaging(@Param("cri") MessageCriteria cri, @Param("chatroom_id") String chatroomId);
	List<Member> getAllMembers();
	int createChatroom(Chatroom chatroom);
	int insertChatroomMemberRelation(ChatroomMemberRelation chatroomMember);
	int deleteChatroomMemberRelation(ChatroomMemberRelation chatroomMember);
	List<Map<String, String>> searchMessage(@Param("query") String query, @Param("chatroom_id") String chatroomId);
}