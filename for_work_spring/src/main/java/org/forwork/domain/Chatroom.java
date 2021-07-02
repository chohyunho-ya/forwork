package org.forwork.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Chatroom implements Serializable {
	private String chatroom_id;
	private String chatroom_name;
	private String user_id;
}