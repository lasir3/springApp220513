package com.choong.spr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choong.spr.domain.BoardDto;
import com.choong.spr.domain.PageInfoDto;
import com.choong.spr.domain.ReplyDto;
import com.choong.spr.service.BoardService;
import com.choong.spr.service.ReplyService;


@Controller
@RequestMapping("boardApp")
public class BoardController {

	// Service Autowired
	@Autowired
	private BoardService service;
	
	@Autowired
	private ReplyService replyService;
	
	// Board의 list 세팅
//	@GetMapping("board/list")
//	public void listBaord(Model model) {
//		List<BoardDto> list = service.listBoard();
//		model.addAttribute("boardList", list);
//		
//		System.out.println(list.size());
//	}
	// 페이지당 표시할 보드의 갯수
	int rowPerPage = 10;

	@GetMapping("board/list")
	public String listBoard(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
		List<BoardDto> list = service.listBoard(page, rowPerPage);
		int totalRecords = service.countPage();
		int end = (totalRecords - 1) / rowPerPage + 1;
		
		PageInfoDto pageInfo = new PageInfoDto();
		pageInfo.setCurrent(page);
		pageInfo.setEnd(end);
		
		model.addAttribute("boardList", list);
		model.addAttribute("pageInfo", pageInfo);
		
		return "/boardApp/board/list";
	}

	// Board 검색
	@GetMapping("board/search")
	public String searchBoard(@RequestParam("q") String q, @RequestParam(name = "page", defaultValue = "1") int page, Model model) {
		List<BoardDto> list = service.searchBoard(q, page, rowPerPage);
		int totalRecords = service.countSearchPage(q);
		int end = (totalRecords - 1) / rowPerPage + 1;
		
		PageInfoDto pageInfo = new PageInfoDto();
		pageInfo.setCurrent(page);
		pageInfo.setEnd(end);
		
		model.addAttribute("searchList", list);
		model.addAttribute("searchStr", q);
		model.addAttribute("pageInfo", pageInfo);
		
		return "/boardApp/board/search";
	}
	
	// Board list의 title 클릭시 해당 id에 대한 board 정보를 get.jsp로 포워드
	@GetMapping("board/{id}")
	// @Pathvariable을 통해 변수명을 url 경로에 추가
	public String getBoard(@PathVariable("id") int id, Model model) {
		// Service를 시켜 id에 해당하는 게시물 get
		BoardDto dto = service.getBoard(id);
		System.out.println(dto.getViews());
		
		// 댓글 리스트 get
		List<ReplyDto> replyDto = replyService.getReplyListByBoardId(id);
		
		model.addAttribute("board", dto);
		model.addAttribute("replyList", replyDto);
		
		return "/boardApp/board/get";
	}
	
	@PostMapping("board/modify")
	public String modifyBoard(BoardDto board, RedirectAttributes rttr) {
		boolean success = service.updateBoard(board);
		if (success) {
			rttr.addAttribute("success", true);
			System.out.println("게시물 수정 성공!!");
			return "redirect:/boardApp/board/" + board.getId();
		} else {
			rttr.addAttribute("success", false);
			System.out.println("게시물 수정 실패..");
			return "redirect:/boardApp/board/" + board.getId();
		}
	}
	
	@PostMapping("board/remove")
	public String removeBoard(int id) {
		boolean success = service.removeBoard(id);
		if (success) {
			System.out.println("게시물 삭제 성공!!");
		} else {
			System.out.println("게시물 삭제 실패...");
		}
		return "redirect:/boardApp/board/list";
	}
	
	@GetMapping("board/write")
	public void writeBoard() {
		
	}
	
	@PostMapping("board/write")
	public String writeBoardProcess(BoardDto board) {
		boolean success = service.addBoard(board);
		
		if (success) {
			System.out.println("게시물 작성 성공!!");
		} else {
			System.out.println("게시물 작성 실패...");
		}
		return "redirect:/boardApp/board/" + board.getId();
	}
}
