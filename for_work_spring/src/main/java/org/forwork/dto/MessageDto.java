package org.forwork.dto;

import java.io.Serializable;

import org.forwork.domain.Member;

import lombok.Data;

@Data
public class MessageDto implements Serializable {
	private static final long serialVersionUID = -7353484588260422449L;
	private String message_id;
	private String message;
	private String send_time;
	private String chatroom_id;
	private Member sender;	
	private String file_path;
	private String is_info;
}