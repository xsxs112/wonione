package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Board;

@Mapper
public interface BoardMapper {
	
	//공지사항 목록 조회
	public List<Board> getNotice(Board board);
		
	//공지사항 등록
	public int addNotice(Board board);

	//게시물 글번호(PK) 자동증가
	public Map<String, Object> getBoardNum();
	
	//자료게시판 목록 조회
	public List<Board> getDataLibrary(Board board);

	//게시물 읽기
	public Board readBoard(String boardNum);
	
	//게시물 수정
	public int modifyBoard(Board board);
	
	//게시물 삭제
	public int removeBoard(String boardNum);
	
	//조건 검색
	public List<Board> getSearch(String bdSk, String bdSv);
}