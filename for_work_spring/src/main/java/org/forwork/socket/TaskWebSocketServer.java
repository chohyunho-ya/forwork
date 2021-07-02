
package org.forwork.socket;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j;

@Controller
@ServerEndpoint(value = "/taskSocket/{project_id}") // socket connection url
@Log4j
public class TaskWebSocketServer {
	private static final Map<Integer, List<Session>> sessionMap = new HashMap<Integer, List<Session>>();
	
	public TaskWebSocketServer() { // websocket 생성
		System.out.println("web socket create");
	}
	
	
	@OnOpen
	public void onOpen(Session session, @PathParam("project_id")int project_id){ 
		log.info("open session : " + session.getId());
		try{ // 정상적으로 연결시 메세지 전달
			final Basic basic = session.getBasicRemote();
			basic.sendText("연결 완료");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(sessionMap.containsKey(project_id)){
			sessionMap.get(project_id).add(session);
		}else{
			sessionMap.put(project_id, new ArrayList<>());
			sessionMap.get(project_id).add(session);
		}
	}
	
	private void sendAllSessionToMessage(Session self,String msg,int projcet_id){ // 모든 session의 유저에게 메세지 전달 broadCast
		try {
			for(Session s : TaskWebSocketServer.sessionMap.get(projcet_id)){
				if(!self.getId().equals(s.getId())){
					s.getBasicRemote().sendText("c");
				}
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
	
	
	@OnMessage // 메세지 전달시
	public void onMessage (String message, Session session,@PathParam("project_id")int project_id){
		try {
			//메세지 보낸 사람에게 표시될 내용
			final Basic basic = session.getBasicRemote();
			basic.sendText("변경하였습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 다른 사람에게 메세지 보내기
		sendAllSessionToMessage(session,message,project_id); // 전달 받은 메세지 broad cast
	}
	
	@OnError
	public void onError(Throwable e, Session session){
		log.info(e.getMessage() + "by session : " + session.getId());
	}
	
	@OnClose
	public void onClose(Session session, @PathParam("project_id")int project_id){
		log.info("Session : "+ session.getId() + " closed");
		sessionMap.get(project_id).remove(session); // 연결 종료 시 session 삭제
	}
}