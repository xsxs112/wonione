package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Board;

@Mapper
public interface BoardMapper {
	
	//공지사항 목록 조회
	public List<Board> getNotice(Board board);
	
	//공지사항 읽기 (글번호로 조회)
	public Board readNotice(String boardNum);
	
	//자료게시판 목록 조회
	public List<Board> getDataLibrary(Board board);

}