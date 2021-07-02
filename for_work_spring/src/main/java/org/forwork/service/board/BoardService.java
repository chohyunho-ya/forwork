package org.forwork.service.board;

import java.util.List;

import org.forwork.domain.Board;

public interface BoardService {
	
	public int init(int project_id);
	
	public int register(Board board);
	
	public Board get(Long board_id);
	
	public int modify(Board board);
	
	public int remove(Long board_id);
	
	public List<Board> getList(int project_id);
}
