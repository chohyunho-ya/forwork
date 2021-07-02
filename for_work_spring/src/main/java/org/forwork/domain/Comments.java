package org.forwork.domain;

import lombok.Data;

@Data
public class Comments {

	private Long comment_id;
	private Long post_id;
	private int member_id;
	private String member_name;
	private String comment_date;
	private String comment_content;
}
