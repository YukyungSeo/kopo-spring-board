package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {
	List<BoardVO> selectAll();

	BoardVO selectOne(int boardNo);
	
	void insert(BoardVO board);
}
