package com.mycompany.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.mycompany.board.dao.BoardDao;
import com.mycompany.board.dto.BoardDto;

public class BListCommand implements BCommand {
	public void execute(Model model, HttpServletRequest request) {
		BoardDao boardDao = new BoardDao();
		List<BoardDto> boardDtos = boardDao.boardlist();
		model.addAttribute("boardDtos", boardDtos);
	}
}
