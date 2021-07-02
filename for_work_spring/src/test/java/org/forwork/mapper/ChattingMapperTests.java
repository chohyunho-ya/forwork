package org.forwork.mapper;

import org.forwork.domain.Message;
import org.forwork.dto.MemberStatus;
import org.forwork.dto.MessageCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ org.forwork.config.RootConfig.class, org.forwork.config.SecurityConfig.class})
@Log4j
public class ChattingMapperTests {

	@Setter(onMethod_= @Autowired)
	ChattingMapper mapper;
	
//	@Test
//	public void testMapper(){
//		log.info(mapper);
//	}
//	
//	@Test
//	public void testGetChatroomMemberRelation() {
//		mapper.getChatroomMemberRelation().forEach( relation -> log.info(relation));
//	}
//	
//	@Test
//	public void testInsertMessage() {
//		Message msg = new Message();
//		msg.setMessage("test");
//		msg.setChatroom_id("3");
//		msg.setSender("1");
//		msg.setSend_time("2021-05-11 15:40:00");
//		mapper.insertMessage(msg);
//	}
//	
//	@Test
//	public void testGetMessageByChatroomId() {
//		mapper.getMessageByChatroomId("1").forEach( msg -> log.info(msg));
//	}
//	
//	@Test
//	public void testGetChatroomByMemberId() {
//		mapper.getChatroomByMemberId("1").forEach( chatroom -> log.info(chatroom));
//	}
//	
//	@Test
//	public void tesetGetMemberById() {
//		log.info(mapper.getMemberById("1"));
//	}
//	
//	@Test
//	public void testGetLastMessagePerChatroomByMemberId() {
//		log.info(mapper.getLastMessagePerChatroomByMemberId("1"));
//	}
//	
//	@Test
//	public void testUnreadCount() {
//		log.info(mapper.countUnreadPerChatroomByMemberId("1"));
//	}
//	
//	@Test
//	public void testGetMessagesWithPaging() {
//		MessageCriteria cri = new MessageCriteria();
//		cri.setAmount(10);
//		cri.setPageNum(3);
//		mapper.getMessageByChatroomIdWithPaging(cri, "1").forEach(msg -> log.info(msg));;
//	}
//	
//	@Test
//	public void 퇴장메시지_생성() {
//		Message msg = new Message();
//		msg.setIs_info("y");
//		msg.setSender("1");
//		msg.setMessage("info");
//		msg.setChatroom_id("3");
//		msg.setSend_time("2021-05-11 15:40:00");
//		msg.setFile_path("");
//		mapper.insertMessage(msg);
//	}
}
