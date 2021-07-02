package org.forwork.domain;

import lombok.Data;

@Data
public class Attach {

	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	private Long post_id;
}
