package org.forwork.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class ChatroomMemberRelation implements Serializable {
	private String chatroom_id;
	private String member_id;
}