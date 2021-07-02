package org.forwork.dto;

import lombok.Data;

@Data
public class MessageCriteria {
	private int pageBefore;
	private	int pageNum;
	private int amount;
}
