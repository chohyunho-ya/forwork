package org.forwork.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class CommentPageDto {

	private int commentCnt;
	private List<Comments> list;
}
