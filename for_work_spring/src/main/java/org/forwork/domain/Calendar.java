package org.forwork.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Calendar {
	private String calendar_id;
	private String project_id;
	private String calendar_content;
	private Date calendar_start_date;
	private Date calendar_end_date;
	private String allDay;
}
