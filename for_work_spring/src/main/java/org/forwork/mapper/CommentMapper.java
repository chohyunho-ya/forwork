package org.forwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.forwork.domain.Comments;
import org.forwork.domain.Criteria;


public interface CommentMapper {
	
	public int insertComment(Comments comments);
	
	public int insertCommentSelectKey(Comments comments);
	
	public List<Comments> listComment(@Param("cri") Criteria cri, @Param("post_id") Long post_id);
	
	public List<Comments> listCommentPaging(@Param("cri") Criteria cri, @Param("post_id") Long post_id);
	
	public int getCountByPost(Long post_id);
	
	public int deleteComment(Long comment_id);
	
	public int updateComment(Comments comments);
	
	public Comments getComment(Long comment_id);
}
