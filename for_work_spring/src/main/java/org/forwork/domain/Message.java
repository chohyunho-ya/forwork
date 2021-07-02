package org.forwork.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Message implements Serializable {
	private static final long serialVersionUID = -7353484588260422449L;
	private String message_id;
	private String message;
	private String send_time;
	private String chatroom_id;
	private String sender;
	private String file_path;
	private String is_info;
}