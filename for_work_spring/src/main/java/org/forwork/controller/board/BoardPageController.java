package org.forwork.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.forwork.domain.Criteria;
import org.forwork.dto.PageDto;
import org.forwork.service.board.BoardService;
import org.forwork.service.board.PostService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardPageController {

	private BoardService boardService;
	private PostService postService;
	
	@GetMapping("/main/{project_id}")
	public String main(@PathVariable(name = "project_id") int project_id, Model model) {
		log.info("프로젝트별 게시판 메인");
		
		boardService.init(project_id); // 새 프로젝트 공지 사항, 기본 게시판 생성
		
		model.addAttribute("menu", boardService.getList(project_id)); // 게시판 메뉴
		model.addAttribute("notice", postService.getNotice(project_id)); // 공지 사항
		model.addAttribute("board", postService.getBoard(project_id)); // 최신 글
		model.addAttribute("project_id", project_id);
		
		return "board/main";
	}
	
	@GetMapping("/list")
	public void list(int project_id, Long board_id, Criteria cri, Model model) {
		log.info("게시판별 게시글 목록");
		log.info("cri: " + cri);
		
		int total = postService.getTotal(cri, board_id);
		
		if (total < 10) {
			cri.setAmount(total);
		} else {
			cri.setAmount(10);
		}
		
		model.addAttribute("menu", boardService.getList(project_id));
		model.addAttribute("board", boardService.get(board_id)); // 게시?�� ?���?
		model.addAttribute("list", postService.getListPage(cri, board_id)); // 게시�? 목록
		model.addAttribute("pageMaker", new PageDto(cri, total));
	
	}

	@GetMapping("/manager")
	public void manager(int project_id, Long board_id, Model model) {
		log.info("게시판 관리 페이지");
		
		model.addAttribute("menu", boardService.getList(project_id));
		model.addAttribute("project_id", project_id);
	}
	
	@GetMapping("/post")
	public void post(@RequestParam("project_id") int project_id, @RequestParam("board_id") Long board_id, 
			@RequestParam("post_id") Long post_id, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("게시�? ?��?�� 보기");
		postService.addHitcount(post_id); // 조회 수
		model.addAttribute("menu", boardService.getList(project_id));
		model.addAttribute("board", boardService.get(board_id)); 
		model.addAttribute("post", postService.get(post_id));
	}

	@GetMapping("/updatePost")
	public void updatePost(@RequestParam("project_id") int project_id, @RequestParam("board_id") Long board_id, 
			@RequestParam("post_id") Long post_id, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("게시글 수정 페이지");
		model.addAttribute("menu", boardService.getList(project_id));
		model.addAttribute("board", boardService.get(board_id)); 
		model.addAttribute("post", postService.get(post_id));
	}

	@GetMapping("/insertPost")
	public void insertPost(int project_id, Long board_id, Model model) {
		log.info("게시글 등록 페이지");
		
		model.addAttribute("menu", boardService.getList(project_id));
		model.addAttribute("board", boardService.get(board_id)); 
	}
	
}
