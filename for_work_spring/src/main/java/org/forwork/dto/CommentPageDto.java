package org.forwork.dto;

import java.util.List;

import org.forwork.domain.Comments;

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
