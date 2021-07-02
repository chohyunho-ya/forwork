package org.forwork.controller.board;


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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.forwork.domain.Attach;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.forwork.domain.Post;
import org.forwork.service.board.PostService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/post/")
@RestController
@Log4j
@AllArgsConstructor
public class PostController {

	private PostService service;
	
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody Post post) {
		log.info("Post: " + post);
		
		int insertCount = service.register(post);
		log.info("게시글 추가: " + insertCount);
		
		return insertCount == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH }, value = "/{post_id}", 
			consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody Post post, @PathVariable("post_id") Long post_id) {
		post.setPost_id(post_id);
		log.info("post_id: " + post_id);
		log.info("게시글 수정: " + post);
		
		return service.modify(post) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value = "/{post_id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("post_id") Long post_id) {
		log.info("게시글 삭제: " + post_id);

		int result = service.remove(post_id);
		List<Attach> attachList = service.getAttachList(post_id);		
		if (result == 1) {
			// 첨부 파일 삭제
			deleteFiles(attachList);			
		}
		
		return result == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<Attach>> getAttachList(Long post_id) {
		log.info("getAttachList " + post_id);
		
		return new ResponseEntity<>(service.getAttachList(post_id), HttpStatus.OK);
	}
	
	private void deleteFiles(List<Attach> attachList) {

		if (attachList == null || attachList.size() == 0) {
			return;
		}

		log.info("delete attach files...................");
		log.info(attachList);

		attachList.forEach(attach -> {
			try {
				Path file = Paths.get(
						"C:\\upload\\" + attach.getUploadPath() + "\\" + attach.getUuid() + "_" + attach.getFileName());

				Files.deleteIfExists(file);

			} catch (Exception e) {
				log.error("delete file error" + e.getMessage());
			} // end catch
			
		});// end foreachd
	}
	
	
	
	
	
}
