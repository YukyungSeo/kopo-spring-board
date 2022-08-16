package kr.ac.kopo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getAllBoard() {
		return boardDAO.selectAll();
	}

	@Override
	public BoardVO getOneBoard(int boardNo) {
		// TODO Auto-generated method stub
		return boardDAO.selectOne(boardNo);
	}

	@Override
	public void addBoard(BoardVO board) {
		boardDAO.insert(board);
	}

}
