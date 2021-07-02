package org.forwork.service;

import org.forwork.domain.Message;
import org.forwork.service.chatting.ChattingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ org.forwork.config.RootConfig.class, org.forwork.config.SecurityConfig.class })
@Log4j
public class ChattingServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private ChattingService service;
	
//	@Setter(onMethod_ = @Autowired)
//	private GetSetService service2;
//	
//	@Test
//	public void testExists() {
//		log.info(service2);
//		assertNotNull(service2);
//	}
//	
//	@Test
//	public void testFindChatroomMemberRelations() {
//		service.findChatroomMemberRelations().forEach(relation -> log.info(relation));
//	}
//	
//	@Test
//	public void testFindChatroomName() {
//		service.findChatroomName("3");
//	}
//	
//	@Test
//	public void testInsertMessage() {
//		Message msg = new Message();
//		msg.setMessage("마지막 메세지 테스트22");
//		msg.setChatroom_id("1");
//		msg.setSender("1");
//		msg.setSend_time("2021-05-17 14:32:00");
//		service.createMessage(msg);
//	}
//	
//	@Test
//	public void testUpdateReadStatus() {
//		service.updateReadStatus("267", "4");
//	}
//	
//	@Test
//	public void testUpdateReadAll() {
//		service.updateReadAll("1", "2");
//	}
//	
//	@Test
//	public void 캐시_테스트() {
//		service2.test();
//	}
//	
//	@Test
//	public void 메시지생성시_캐시업데이트() {
//		Message msg = new Message();
//		msg.setMessage("메시지 생성 및 캐시 업데이트");
//		msg.setChatroom_id("1");
//		msg.setSender("1");
//		msg.setSend_time("2021-05-25 10:14:00");
//		service.createMessage(msg);
//	}
//	
//	@Test
//	public void 캐시에_있는_마지막메시지_가져오기() {
//		service.findLastMessagePerChatroomByMemberId("1");
//	}
//
//	@Test
//	public void 메세지아이디_페이지번호_알아내기() {
//		service.searchMessage("1", "1", "20");
//	}
}