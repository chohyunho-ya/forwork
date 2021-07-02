package org.forwork.service.board;

import java.util.List;

import org.forwork.domain.Post;
import org.forwork.domain.Attach;
import org.forwork.domain.Criteria;

public interface PostService {

	public int register(Post post);
	
	public Post get(Long post_id);
	
	public int addHitcount(Long post_id);
	
	public int modify(Post post);
	
	public int remove(Long post_id);
	
	public List<Post> getList(Long board_id);
	
	public List<Post> getListPage(Criteria cri, Long board_id);
	
	public int getTotal(Criteria cri, Long board_id);
	
	public List<Post> getNotice(int project_id);
	
	public List<Post> getBoard(int project_id);
	
	public List<Attach> getAttachList(Long post_id);
	
}
