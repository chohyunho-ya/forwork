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
import org.forwork.domain.CommentPageDto;
import org.forwork.domain.Comments;
import org.forwork.domain.Criteria;
import org.forwork.service.board.CommentService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/comments/")
@RestController
@Log4j
@AllArgsConstructor
public class CommentController {

	private CommentService service;
	
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody Comments comment) {
		log.info("Comment: " + comment);
		
		log.info("@!!!!!!!!!!!!!!!!!!!!member_name: " + comment.getMember_name());
		
		int insertCount = service.register(comment);
		log.info("comment insert count: " + insertCount);
		
		return insertCount == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/pages/{post_id}/{page}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<CommentPageDto> getList(@PathVariable("page") int page, @PathVariable("post_id") Long post_id) {
		log.info("get list page...");
		
		Criteria cri = new Criteria(page, 5);
		
		log.info("get comment list post_id: " + post_id);
		log.info("cri: " + cri);
		
		return new ResponseEntity<>(service.getListPage(cri, post_id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{comment_id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Comments> get(@PathVariable("comment_id") Long comment_id) {
		log.info("get: " + comment_id);
		
		return new ResponseEntity<>(service.get(comment_id), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{comment_id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("comment_id") Long comment_id) {
		log.info("remove: " + comment_id);
		
		return service.remove(comment_id) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH }, value = "/{comment_id}", 
			consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody Comments comment, @PathVariable("comment_id") Long comment_id) {
		comment.setComment_id(comment_id);
		log.info("comment_id: " + comment_id);
		log.info("modify: " + comment);
		
		return service.modify(comment) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
