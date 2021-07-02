package org.forwork.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class PMODto {

	private String project_id;
	private String project_title;
	private String project_start_date;
	private String project_end_date;
	
	private String approval_id;
	private Date register_date;
	private Date check_date;
	private Date complete_date;
	private String name;
	private String is_pm;
	private String approval_detail;

	private int count;
	
}
