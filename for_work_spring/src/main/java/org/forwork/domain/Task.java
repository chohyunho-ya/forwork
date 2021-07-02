package org.forwork.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	private String task_id;
	private String project_id;
	private String task_type_id;
	private String responsibility;
	private String writer;
	private String task_content;
	private String task_index;
	private String name;
	private String writer_name;
}
