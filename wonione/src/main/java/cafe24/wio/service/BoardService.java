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
	
	//공지사항 조회
	public List<Board> getNotice(Board board){
		System.out.println(board + " <-- board");
		List<Board> noticeList = boardMapper.getNotice(board);
		return noticeList;
	}
	
	//공지사항 읽기
	public Board readNotice(String boardNum) {
		Board board = boardMapper.readBoard(boardNum);
		return board;
	}
	
	//공지사항 작성
	public int insertNotice(Board board) {
		int write = boardMapper.insertNotice(board);
		return write;		
	}
	
	//공지사항 수정
	public int modifyNotice(Board board) {
		int modify = boardMapper.modifyBoard(board);
		return modify;
	}
	
	//자료게시판 조회
	public List<Board> getDataLibrary(Board board){
		System.out.println(board + " <-- board");
		List<Board> dataList = boardMapper.getDataLibrary(board);
		return dataList;
	}

	//자료게시판 읽기
	public Board readDataLibrary(String boardNum) {
		Board board = boardMapper.readBoard(boardNum);
		return board;
	}
	
	//게시물 삭제
	public int removeNotice(String boardNum) {
		int remove = boardMapper.removeBoard(boardNum);
		return remove;		
	}



}
