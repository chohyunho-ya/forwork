package org.forwork.service.board;

import java.util.List;

import org.forwork.service.board.BoardService;
import org.springframework.stereotype.Service;
import org.forwork.domain.Board;
import org.forwork.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;

	@Override
	public int init(int project_id) {
		
		if (mapper.listBoardMenu(project_id).size() == 0) {
			log.info("?ƒˆ ?”„ë¡œì ?Š¸ ê³µì? ?‚¬?•­, ê¸°ë³¸ ê²Œì‹œ?Œ ?ƒ?„±...");
			
			mapper.insertNoticeBoard(project_id);
			mapper.insertDefaultBoard(project_id);
		}
		
		return mapper.listBoardMenu(project_id).size();
	}
	
	@Override
	public int register(Board board) {
		log.info("?ƒˆ ê²Œì‹œ?Œ ?“±ë¡?..." + board);
		
		return mapper.insertBoardSelectKey(board);
	}

	@Override
	public Board get(Long board_id) {
		log.info("ê²Œì‹œ?Œ ?´ë¦?..." + board_id);
		
		return mapper.getBoard(board_id);
	}

	@Override
	public int modify(Board board) {
		log.info("ê²Œì‹œ?Œ ?ˆ˜? •..." + board);
		
		return mapper.updateBoard(board);
	}

	@Override
	public int remove(Long board_id) {
		log.info("ê²Œì‹œ?Œ ?‚­? œ..." + board_id);
		
		return mapper.deleteBoard(board_id);
	}

	@Override
	public List<Board> getList(int project_id) {
		log.info("?”„ë¡œì ?Š¸ë³? ê²Œì‹œ?Œ ëª©ë¡...");
		
		return mapper.listBoardMenu(project_id);
	}


}
