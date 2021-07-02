package org.forwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamProgress {
	
	private int storiesCount;
	private int todoCount;
	private int doingCount;
	private int doneCount;
	private int totalCount;
	private String name;
	private int responsibility;
	private int project_id;
	private String task_content;

}
