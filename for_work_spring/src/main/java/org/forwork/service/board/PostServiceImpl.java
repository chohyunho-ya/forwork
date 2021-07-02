package org.forwork.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.forwork.domain.Attach;
import org.forwork.domain.Criteria;
import org.forwork.domain.Post;
import org.forwork.mapper.AttachMapper;
import org.forwork.mapper.PostMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
	
	@Setter(onMethod_=@Autowired)
	private PostMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private AttachMapper attachMapper;

	@Override
	public int register(Post post) {
		log.info("게시글 추가..." + post);
		int result = mapper.insertPostSelectKey(post);
		
		// 첨부 파일 추가
		if (post.getAttachList() != null || post.getAttachList().size() > 0) {
			post.getAttachList().forEach(attach -> {
				attach.setPost_id(post.getPost_id());
				attachMapper.insert(attach);
			});
		}
		
		return result;
	}

	@Override
	public Post get(Long post_id) {
		log.info("게시글 상세 보기..." + post_id);
		
		return mapper.getPost(post_id);
	}
	
	@Override
	public int addHitcount(Long post_id) {
		log.info("게시글 조회 수");
		
		return mapper.updateHitcount(post_id);
	}

	@Override
	public int modify(Post post) {
		log.info("게시글 수정..." + post);
		
		attachMapper.deleteAll(post.getPost_id());
		
		int result = mapper.updatePost(post);
		boolean modifyResult = result == 1;
		
		if (modifyResult && post.getAttachList() != null && post.getAttachList().size() > 0) {
			post.getAttachList().forEach(attach -> {
				attach.setPost_id(post.getPost_id());
				attachMapper.insert(attach);
			});
		}
		
		return result;
	}

	@Override
	public int remove(Long post_id) {
		log.info("게시글 삭제..." + post_id);
		
		attachMapper.deleteAll(post_id);
		
		return mapper.deletePost(post_id);
	}

	@Override
	public List<Post> getList(Long board_id) {
		log.info("게시판별 게시글 목록..." + board_id);
		
		return mapper.listPost(board_id);
	}

	@Override
	public List<Post> getListPage(Criteria cri, Long board_id) {
		return mapper.listPostWithPaging(cri, board_id);
	}
	
	@Override
	public int getTotal(Criteria cri, Long board_id) {
		log.info("get total count");
		return mapper.getCountByBno(cri, board_id);
	}	
	
	@Override
	public List<Post> getNotice(int project_id) {
		log.info("프로젝트별 공지 사항 미리 보기...");
		
		return mapper.listNotice(project_id);
	}

	@Override
	public List<Post> getBoard(int project_id) {
		log.info("프로젝트별 최신 글 목록...");
		
		return mapper.listBoard(project_id);
	}

	@Override
	public List<Attach> getAttachList(Long post_id) {
		log.info("get attach list by post_id " + post_id);
		
		return attachMapper.findByPost(post_id);
	}
	
}
