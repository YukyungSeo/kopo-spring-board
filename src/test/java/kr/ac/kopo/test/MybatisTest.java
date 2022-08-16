package kr.ac.kopo.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })
public class MybatisTest {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Test
	public void myBatisT() {
		assertNotNull(sqlSessionTemplate);
	}

	@Test
	public void boardSelectAllTest() {
		List<BoardVO> boardlist = sqlSessionTemplate.selectList("board.dao.boardDAO.selectAll");
		for (BoardVO board : boardlist) {
			System.out.println(board);
		}
	}

	@Test
	public void boardSelectByNo() {
		BoardVO board = sqlSessionTemplate.selectOne("board.dao.boardDAO.selectByNo", 3);
		System.out.println(board);
	}

	@Ignore
	@Test
	public void boardInsert() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("test");
		boardVO.setWriter("someone");
		boardVO.setContent("insert test!");

		sqlSessionTemplate.insert("board.dao.boardDAO.insert", boardVO);
	}

	@Test
	public void memberSelectUser() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("admin");
		memberVO.setPassword("admin");
		
		MemberVO member = sqlSessionTemplate.selectOne("member.dao.memberDAO.selectUser", memberVO);
		System.out.println(member);
		assertNotNull(member);
	}
}