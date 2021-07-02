package org.forwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectLanguage {
	
	private int project_language_seq;
	private int project_id;
	private String project_language;

}
