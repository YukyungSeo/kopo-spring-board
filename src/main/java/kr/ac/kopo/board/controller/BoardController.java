package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	// 상세 게시글 조회
	// /board/detail?boardNo=3
	@RequestMapping("/board/detail")
	public String detail(@RequestParam("boardNo") int boardNo, Model model) {
		// DB - 3번 게시글 값을 가져온다.

		// String boardNo = request.getParameter("boardNo");
		BoardVO board = boardService.getOneBoard(boardNo);
		model.addAttribute("board", board);

		// WEB-INF/jsp/board/detail.jsp
		return "board/detail";
	}

	// /board/detail/3
	@RequestMapping("/board/detail/{boardNo}")
	public String detail2(@PathVariable("boardNo") int boardNo, Model model) {
		// DB - 3번 게시글 값을 가져온다.

		// String boardNo = request.getParameter("boardNo");
		BoardVO board = boardService.getOneBoard(boardNo);
		model.addAttribute("board", board);

		// WEB-INF/jsp/board/detail.jsp
		return "board/detail";
	}

	// 새글쓰기
	// /board/write
	// /board/write.jsp
//	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	@GetMapping("/board/write")
	public void writeGet(Model model) {
		// WEB-INF/jsp/board/write.jsp

		BoardVO boardVO1 = new BoardVO();
		model.addAttribute("boardVO1", boardVO1);
//		return "board/write";
	}

	@PostMapping("/board/write")
	public String writePost(@Valid @ModelAttribute("boardVO1") BoardVO board, BindingResult result) {
		// 0. 입력받은 board가 null 값이 포함안되어 있는지 확인한다. BindingResult를 활용
		System.out.println(result);

		if (result.hasErrors()) {
			return "board/write";
		}

		// 1. DB insert 작업
		boardService.addBoard(board);

		// 2. 다 완료 후에는 전체 게시글 list로 이동
		// /board
		return "redirect:/board";
	}

}
