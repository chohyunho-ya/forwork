package org.forwork.mapper;

import java.util.List;

import org.forwork.domain.Board;

public interface BoardMapper {
	
	public int insertNoticeBoard(int project_id);
	
	public int insertDefaultBoard(int project_id);

	public void insertBoard(Board board);
	
	public int insertBoardSelectKey(Board board);
	
	public List<Board> listBoardMenu(int project_id);
	
	public int deleteBoard(Long board_id);
	
	public int updateBoard(Board board);
	
	public Board getBoard(Long board_id);
}
