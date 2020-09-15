package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cafe24.wio.bean.Board;
import cafe24.wio.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//게시판 조회
	public List<Board> getBoardList(Board board){
		List<Board> result = boardMapper.getBoardList(board);
		return result;
	}
	
}
