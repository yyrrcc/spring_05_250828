package com.mycompany.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.board.dao.BoardDao;
import com.mycompany.board.dto.BoardDto;

@Controller
public class BoardController {

	// 글쓰기 양식
	@RequestMapping (value = "/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	// 유저가 쓴 글을 db에 삽입하는 요청 처리
	@RequestMapping (value = "/write")
	public String write(HttpServletRequest request, Model model) {
		BoardDao boardDao = new BoardDao();
		boardDao.write(request.getParameter("bname"), request.getParameter("btitle"), request.getParameter("bcontent"));
		return "redirect:boardlist";
	}
	// 글 목록보기 요청 처리
	@RequestMapping (value = "/boardlist")
	public String boardlist(HttpServletRequest request, Model model) {
		BoardDao boardDao = new BoardDao();
		List<BoardDto> boardDtos = boardDao.boardlist();
		model.addAttribute("boardDtos", boardDtos);
		return "boardlist";
	}
	// 게시판 글 목록에서 제목 클릭했을 때 나오는 글 내용 보기 (getParameter)
	@RequestMapping (value = "/contentview")
	public String contentview(HttpServletRequest request, Model model) {
		String bnum = request.getParameter("bnum");
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = boardDao.contentview(bnum);
		model.addAttribute("boardDto", boardDto);
		return "contentview";
	}
}
