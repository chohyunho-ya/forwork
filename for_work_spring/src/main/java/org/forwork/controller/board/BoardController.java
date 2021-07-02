package org.forwork.controller.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.forwork.domain.Board;
import org.forwork.domain.Post;
import org.forwork.service.board.BoardService;
import org.forwork.service.board.PostService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/board/")
@RestController
@Log4j
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;
	private PostService postService;
	
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody Board board) {
		log.info("Board: " + board);
		
		int insertCount = boardService.register(board);
		log.info("Í≤åÏãú?åê Ï∂îÍ?: " + insertCount);
		
		return insertCount == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@GetMapping(value = "/list/{board_id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
//	public ResponseEntity<List<Post>> getList(@PathVariable("board_id") Long board_id) {
//		log.info("Í≤åÏãú?åêÎ≥? Í≤åÏãúÍ∏? Î™©Î°ù");
//		
//		return new ResponseEntity<>(postService.getList(board_id), HttpStatus.OK);
//	}
	
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH }, value = "/{board_id}", 
			consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody Board board, @PathVariable("board_id") Long board_id) {
		board.setBoard_id(board_id);
		log.info("board_id: " + board_id);
		log.info("Í≤åÏãú?åê ?àò?†ï: " + board);
		
		return boardService.modify(board) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value = "/{board_id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("board_id") Long board_id) {
		log.info("Í≤åÏãú?åê ?Ç≠?†ú: " + board_id);
		
		return boardService.remove(board_id) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
}
