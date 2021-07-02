package org.forwork.dto;

import lombok.Data;

@Data
public class CalendarWeekDto {
	private String id; // calendar_id
	private String title; // calendar_content
	private String start;
	private String end;
	private String allDay;
}
