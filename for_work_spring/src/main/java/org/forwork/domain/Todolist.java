package org.forwork.domain;

import lombok.Data;

@Data
public class Todolist {

	private int todolist_id;
	private int member_id;
	private String todolist_content;
	private String todolist_check;
}
