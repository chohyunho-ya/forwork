package org.forwork.dto;

import lombok.Data;

@Data
public class CalendarDto {
	private String id; // calendar_id
	private String title; // calendar_content
	private String start;
	private String end;
}
