package org.forwork.domain;

import java.util.List;

import org.forwork.domain.Attach;

import lombok.Data;

@Data
public class Post {

	private Long post_id;
	private Long board_id;
	private String post_writer;
	private String post_title;
	private String post_content;
	private int hitcount;
	private String post_date;
	private int commentCnt;
	private List<Attach> attachList;
	
}
