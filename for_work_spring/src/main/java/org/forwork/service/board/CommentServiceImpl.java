package org.forwork.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.forwork.mapper.PostMapper;
import org.forwork.domain.CommentPageDto;
import org.forwork.domain.Comments;
import org.forwork.domain.Criteria;
import org.forwork.mapper.CommentMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CommentServiceImpl implements CommentService {
	
	@Setter(onMethod_=@Autowired)
	private CommentMapper mapper;

	@Setter(onMethod_=@Autowired)
	private PostMapper postMapper;
	
	@Transactional
	@Override
	public int register(Comments comment) {
		log.info("register..." + comment);
		
		postMapper.updateCommentCnt(comment.getPost_id(), 1);
		
		return mapper.insertComment(comment);
	}

	@Override
	public Comments get(Long comment_id) {
		log.info("get..." + comment_id);
		
		return mapper.getComment(comment_id);
	}

	@Override
	public int modify(Comments comment) {
		log.info("modify..." + comment);
		
		return mapper.updateComment(comment);
	}

	@Transactional
	@Override
	public int remove(Long comment_id) {
		log.info("remove..." + comment_id);
		
		Comments comment = mapper.getComment(comment_id);
		postMapper.updateCommentCnt(comment.getPost_id(), -1);
		
		return mapper.deleteComment(comment_id);
	}

	@Override
	public List<Comments> getList(Criteria cri, Long post_id) {
		log.info("get comment list of a post " + post_id);
		
		return mapper.listComment(cri, post_id);
	}

	@Override
	public CommentPageDto getListPage(Criteria cri, Long post_id) {
		return new CommentPageDto(mapper.getCountByPost(post_id), mapper.listCommentPaging(cri, post_id));
	}

}
