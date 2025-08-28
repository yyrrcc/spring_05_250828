package com.mycompany.board.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.mycompany.board.dao.BoardDao;
import com.mycompany.board.dto.BoardDto;

public class BContentviewCommand implements BCommand {
	public void execute(Model model, HttpServletRequest request) {

	String bnum = request.getParameter("bnum");
	BoardDao boardDao = new BoardDao();
	BoardDto boardDto = boardDao.contentview(bnum);
	model.addAttribute("boardDto", boardDto);
	}
}
