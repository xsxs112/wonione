package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Board;

@Mapper
public interface BoardMapper {
	
	//게시판 목록 조회
	public List<Board> getBoardList(Board board);
	
}
