package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// localhost:9990/kopo-spring-board/board
	@RequestMapping("/board")
	public String allBoard(HttpServletRequest request) {
		
		List<BoardVO> boardList = boardService.getAllBoard();
		request.setAttribute("boardList", boardList);
		
		// WEB-INF/jsp/board/list.jsp
		return "board/list";
	}
	
}
