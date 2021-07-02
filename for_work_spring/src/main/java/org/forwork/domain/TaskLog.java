package org.forwork.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TaskLog {
	private String log_id;
	private String task_id;
	private String log_detail;
	private Date log_time;
	private String project_id;

}
