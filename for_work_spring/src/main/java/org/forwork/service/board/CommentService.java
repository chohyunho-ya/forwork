package org.forwork.service.board;

import java.util.List;

import org.forwork.domain.CommentPageDto;
import org.forwork.domain.Comments;
import org.forwork.domain.Criteria;

public interface CommentService {

	public int register(Comments comment);
	
	public Comments get(Long comment_id);
	
	public int modify(Comments comment);
	
	public int remove(Long comment_id);
	
	public List<Comments> getList(Criteria cri, Long post_id);
	
	public CommentPageDto getListPage(Criteria cri, Long post_id);
	
}
