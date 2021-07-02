
package org.forwork.dto;

import java.util.List;

import org.forwork.domain.Chatroom;

import lombok.Data;

@Data
public class ChatroomDto {
	List<Chatroom> chatrooms;
}