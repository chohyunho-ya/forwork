package org.forwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.forwork.domain.Post;
import org.forwork.domain.Criteria;

public interface PostMapper {

	public void insertPost(Post post);
	
	public int insertPostSelectKey(Post post);
	
	public List<Post> listPost(@Param("board_id") Long board_id);
	
	public List<Post> listPostWithPaging(@Param("cri") Criteria cri, @Param("board_id") Long board_id);

	public int getCountByBno(@Param("cri") Criteria cri, @Param("board_id") Long board_id);
	
	public List<Post> listNotice(@Param("project_id") int project_id);
	
	public List<Post> listBoard(@Param("project_id") int project_id);
	
	public Post getPost(Long post_id);
	
	public int updateHitcount(Long post_id);
	
	public int updatePost(Post post);
	
	public int deletePost(Long post_id);
	
	public void updateCommentCnt(@Param("post_id") Long post_id, @Param("amount") int amount);
}
