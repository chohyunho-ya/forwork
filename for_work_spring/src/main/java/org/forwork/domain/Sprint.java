package org.forwork.domain;

import lombok.Data;

@Data
public class Sprint {

	private String sprint_id;
	private String sprint_title;
	private String sprint_color;
	private String project_id;
	private String sprint_start_date;
	private String sprint_end_date;
}
